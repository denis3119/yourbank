package com.yourbank.data.config.repository;

import com.yourbank.data.model.common.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @author Yugov Alexandr.
*/
public interface EntityRepository<T extends Identifiable> extends JpaRepository<T, Long> {
}
