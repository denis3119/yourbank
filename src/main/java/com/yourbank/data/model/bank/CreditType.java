package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author admin.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreditType extends AbstractExpiringEntity {

    private String name;

    @ManyToMany
    private List<Credit> credits;
}
