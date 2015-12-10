package com.yourbank.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yugov Alexandr.
 */
public interface EntityRepository<T extends Identifiable> extends JpaRepository<T, Long> {
}
