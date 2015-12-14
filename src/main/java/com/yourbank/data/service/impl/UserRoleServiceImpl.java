package com.yourbank.data.service.impl;

import com.yourbank.data.model.user.UserRole;
import com.yourbank.data.repository.UserRoleRepository;
import com.yourbank.data.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public UserRole add(UserRole entity) {
        if (getByRole(entity.getRole()) != null) {
            return getByRole(entity.getRole());
        }
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

    @Override
    public List<UserRole> update(List<UserRole> userRoles) {
        List<UserRole> result = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            result.add(update(userRole));
        }
        return result;
    }

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getByRole(String role) {
        return userRoleRepository.getByRole(role);
    }
}
