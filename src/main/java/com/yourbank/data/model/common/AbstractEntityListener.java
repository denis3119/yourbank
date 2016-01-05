package com.yourbank.data.model.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by admin on 05.01.2016.
 */
public class AbstractEntityListener {

    @PreUpdate
    public void preUpdate(AbstractEntity abstractEntity) {
        abstractEntity.setModificationDate(new Date());
    }

    @PrePersist
    public void prePersist(AbstractEntity abstractEntity) {
        abstractEntity.setCreationDate(new Date());
        abstractEntity.setModificationDate(new Date());
    }
}
