package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author admin.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScoreType extends AbstractExpiringEntity {
    private String name;

}
