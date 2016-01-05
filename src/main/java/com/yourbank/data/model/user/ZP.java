package com.yourbank.data.model.user;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author admin
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
//последние 3 месяца
public class ZP extends AbstractExpiringEntity {
    private double value;
    @OneToOne
    private UserProfile userProfile;
}
