package com.yourbank.common;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by admin on 11/2/2015.
 */
@MappedSuperclass
public class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;

    @Transient
    private boolean markedForDelete = false;


    public EffectiveRange getEffectiveRange() {
        return effectiveRange;
    }

    public boolean isMarkedForDelete() {
        return markedForDelete;
    }

    public void setMarkedForDelete(boolean markedForDelete) {
        this.markedForDelete = markedForDelete;
    }

    public void markForDelete() {
        markedForDelete = true;
        effectiveRange.setEffectiveEndDate(new Date());
    }

    public void restore() {
        markedForDelete = false;
        effectiveRange.setEffectiveEndDate(null);
    }

    public boolean expired() {
        return effectiveRange.getEffectiveEndDate() != null;
    }

}
