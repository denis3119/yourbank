package com.yourbank.data.service;


import com.yourbank.data.model.user.UserRole;

/**
 * @author admin.
 */
public interface UserRoleService extends Service<UserRole> {
    UserRole getByRole(String role);
}
