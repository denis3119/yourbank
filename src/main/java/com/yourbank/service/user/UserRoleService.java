package com.yourbank.service.user;


import com.yourbank.data.model.user.Group;

/**
 * @author admin.
 */
public interface UserRoleService {
    Group getByRole(String role);
}
