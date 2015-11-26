package com.yourbank.persistence;

import com.yourbank.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
