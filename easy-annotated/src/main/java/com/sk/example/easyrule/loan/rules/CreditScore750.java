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
@Rule(name = "Credit score 750", description = "Checking Credit Score less than 750", priority = 5)
public class CreditScore750 {
    @Condition
    public boolean when(@Fact("participant") Participant participant){
        return participant.getCreditScore() < 750;
    }

    @Action
    public void then(@Fact("rate") Rate rate){
        log.info("taking action based on credit score 750");
        rate.setLoanStatus("Approved");
        rate.setLoanRate(6.25);
    }
}
