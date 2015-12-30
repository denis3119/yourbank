package com.yourbank.data.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

/**
 * Created by admin on 11/2/2015.
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public class AbstractExpiringEntity extends AbstractEntity {

    @Embedded
    private EffectiveRange effectiveRange;
}
