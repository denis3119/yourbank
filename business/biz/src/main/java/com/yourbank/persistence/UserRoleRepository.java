package com.yourbank.persistence;

import com.yourbank.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author admin.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole getByRole(@Param("role") String role);
}
