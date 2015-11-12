package com.yourbank.account.service.detail;

import com.yourbank.account.User;
import com.yourbank.account.UserRole;
import com.yourbank.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author admin.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        User user = userService.getByName(name);
        // указываем роли для этого пользователя
        HashSet<SimpleGrantedAuthority> roles = new HashSet<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(UserRole.USER.name()));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя

        return new org.springframework.security.core.userdetails.User(user.getName(),
                user.getPassword(),
                roles);
    }

}