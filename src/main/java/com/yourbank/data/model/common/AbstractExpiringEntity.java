package com.yourbank.data.model.common;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * @author admin.
 */
@MappedSuperclass
public abstract class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;

    public void setEffectiveRange(EffectiveRange effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }
}
