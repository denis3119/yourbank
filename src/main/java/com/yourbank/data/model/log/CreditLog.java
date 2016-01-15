package com.yourbank.data.model.log;

import com.yourbank.data.model.common.AbstractExpiringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Created by Vladok on 05.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreditLog extends AbstractExpiringEntity {


}
