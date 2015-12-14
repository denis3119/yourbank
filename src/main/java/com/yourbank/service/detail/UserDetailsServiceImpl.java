package com.yourbank.service.detail;

import com.yourbank.data.model.user.User;
import com.yourbank.data.model.user.UserRole;
import com.yourbank.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @author admin.
*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        User user = userService.getByName(username);
        List<GrantedAuthority> authorities =
                buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<>(setAuths);
    }

}