package com.yourbank.common;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by admin on 11/2/2015.
 */
@Embeddable
public class EffectiveRange {

    private Date effectiveStartDate;

    private Date effectiveEndDate;

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    @Transient
    private boolean markedForDelete = false;

    public void markForDelete() {
        markedForDelete = true;
        setEffectiveEndDate(new Date());
    }

    public void restore() {
        markedForDelete = false;
        effectiveEndDate = null;
    }

    public boolean expired() {
        return effectiveEndDate != null;
    }
}