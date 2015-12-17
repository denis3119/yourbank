package com.yourbank.data.model.user;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Group group;
}
