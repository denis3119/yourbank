package com.yourbank.data.repository;

import com.yourbank.data.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author admin.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole getByRole(@Param("role") String role);
}
