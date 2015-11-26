package com.yourbank.bank;

import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.Entity;

/**
 * @author admin.
 */
@Entity
public class ScoreType extends AbstractExpiringEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
