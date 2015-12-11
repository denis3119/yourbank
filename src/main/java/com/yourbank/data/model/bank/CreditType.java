package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;

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
