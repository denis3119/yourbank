package com.yourbank.service.detail;

import com.yourbank.data.model.user.User;
import com.yourbank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @author admin.
*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User persistedUser = userRepository.getByUsername(username);
        if (persistedUser == null) {
            throw new UsernameNotFoundException("No user found for username: " + username);
        }
        return persistedUser;
    }
}