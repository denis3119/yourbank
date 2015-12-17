package com.yourbank.service.user.impl;

import com.yourbank.data.model.user.Group;
import com.yourbank.data.repository.UserRoleRepository;
import com.yourbank.service.user.UserRoleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    public Group register(Group entity) {
        if (getByRole(entity.getRole()) != null) {
            return getByRole(entity.getRole());
        }
        return userRoleRepository.saveAndFlush(entity);
    }

    public void delete(Group entity) {
        userRoleRepository.delete(entity);
    }

    public Group get(long ID) {
        return userRoleRepository.findOne(ID);
    }

    public Group update(Group entity) {
        return userRoleRepository.saveAndFlush(entity);
    }

    public List<Group> update(List<Group> groups) {
        List<Group> result = new ArrayList<>();
        for (Group group : groups) {
            result.add(update(group));
        }
        return result;
    }

    public List<Group> getAll() {
        return userRoleRepository.findAll();
    }

    public Group getByRole(String role) {
        return userRoleRepository.getByRole(role);
    }
}
