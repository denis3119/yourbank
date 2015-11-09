package com.yourbank.common;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by admin on 11/2/2015.
 */
@MappedSuperclass
public class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;

    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }
}
