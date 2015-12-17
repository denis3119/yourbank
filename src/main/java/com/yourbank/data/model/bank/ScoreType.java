package com.yourbank.data.model.bank;

import com.yourbank.data.model.common.AbstractExpiringEntity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author admin.
 */
@Getter
@Setter
@Entity
public class ScoreType extends AbstractExpiringEntity {

    private String name;
}
