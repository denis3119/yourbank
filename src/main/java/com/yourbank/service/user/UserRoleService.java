package com.yourbank.service.user;


import com.yourbank.data.model.user.UserRole;
import com.yourbank.service.common.Service;

/**
 * @author admin.
 */
public interface UserRoleService extends Service<UserRole> {
    UserRole getByRole(String role);
}
