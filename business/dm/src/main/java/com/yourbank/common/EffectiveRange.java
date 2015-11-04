package com.yourbank.common;

import java.util.Date;

/**
 * Created by admin on 11/2/2015.
 */
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
}
