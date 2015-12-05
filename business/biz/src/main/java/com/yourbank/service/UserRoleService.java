package com.yourbank.service;

import com.yourbank.UserRole;

/**
 * @author admin.
 */
public interface UserRoleService extends Service<UserRole> {
    UserRole getByRole(String role);
}
