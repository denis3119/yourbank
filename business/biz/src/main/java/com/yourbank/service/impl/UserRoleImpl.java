package com.yourbank.service.impl;

import com.yourbank.UserRole;
import com.yourbank.persistence.UserRoleRepository;
import com.yourbank.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin.
 */
@Service
public class UserRoleImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public UserRole add(UserRole entity) {
        return userRoleRepository.saveAndFlush(entity);
    }

    public void delete(UserRole entity) {
        userRoleRepository.delete(entity);
    }

    public UserRole get(long ID) {
        return userRoleRepository.findOne(ID);
    }

    public UserRole update(UserRole entity) {
        return userRoleRepository.saveAndFlush(entity);
    }
}
