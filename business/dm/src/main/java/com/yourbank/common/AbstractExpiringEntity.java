package com.yourbank.common;

import javax.persistence.Embedded;

/**
 * Created by admin on 11/2/2015.
 */
public class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;

    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }
}
