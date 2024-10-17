package com.sk.example.easyrule.loan.rules;

import com.sk.example.easyrule.loan.Participant;
import com.sk.example.easyrule.loan.Rate;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * Created on 10/17/2024
 * {@code @authors} shaji
 */
@Slf4j
@Rule(name = "Credit score 650", description = "Checking Credit Score less than 650", priority = 4)
public class CreditScore650 {
    @Condition
    public boolean when(@Fact("participant") Participant participant){
        return participant.getCreditScore() < 650;
    }

    @Action
    public void then(@Fact("rate") Rate rate){
        log.info("taking action based on credit score 650");
        rate.setLoanStatus("Approved");
        rate.setLoanRate(7.25);
    }
}
