package com.yourbank.data.model.log;


import com.yourbank.data.model.bank.Score;
import com.yourbank.data.model.common.AbstractExpiringEntity;
import com.yourbank.data.model.user.User;
import com.yourbank.util.ScoreUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by Vladok on 05.01.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ScoreLog extends AbstractExpiringEntity{
    @Enumerated(EnumType.STRING)
    ScoreUtil.State state;

    @Enumerated(EnumType.STRING)
    ScoreUtil.Action actionType;
    @ManyToOne
    Score scoreFrom ;
    @ManyToOne
    Score scoreTo ;

    double summ;
    @ManyToOne
    User  user;

    public ScoreLog(ScoreUtil.State state, ScoreUtil.Action actionType , Score scoreFrom, Score  scoreTo, double summ, User user){
        this.state = state;
        this.actionType = actionType;
        this.scoreFrom = scoreFrom;
        this.scoreTo = scoreTo;
        this.summ = summ;
        this.user = user;
    }
}
