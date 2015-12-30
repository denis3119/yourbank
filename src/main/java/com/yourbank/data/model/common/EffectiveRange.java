package com.yourbank.data.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by admin on 11/2/2015.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class EffectiveRange {

    private Date effectiveStartDate;

    private Date effectiveEndDate;


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
