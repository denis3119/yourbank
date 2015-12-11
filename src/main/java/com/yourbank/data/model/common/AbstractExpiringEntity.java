package com.yourbank.data.model.common;

import com.yourbank.data.Identifiable;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by admin on 11/2/2015.
 */
@MappedSuperclass
public class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;

    public void setEffectiveRange(EffectiveRange effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }


}
