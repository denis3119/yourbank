package com.yourbank.data.model.user;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Alexandr Yugov
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class GroupAuthority extends AbstractExpiringEntity {

    @Column(nullable = false)
    private String authority;
}
