package com.yourbank.bank;

import com.yourbank.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author admin.
 */
@Entity
public class CreditType extends AbstractExpiringEntity {
    private String name;
    @ManyToMany
    private List<Credit> credits;

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
