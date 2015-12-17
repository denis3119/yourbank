package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author admin.
 */
@Getter
@Setter
@Entity
public class CreditType extends AbstractExpiringEntity {

    private String name;

    @ManyToMany
    private List<Credit> credits;
}
