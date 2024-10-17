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
@Rule(name = "Annual salary", description = "Checking Annual Salary is greater than 50000", priority = 2)
public class AnnualSalary {
    @Condition
    public boolean when(@Fact("participant") Participant participant){
        return participant.getAnnualSalary() <= 50000;
    }

    @Action
    public void then(@Fact("rate") Rate rate){
        log.info("taking action based on annual salary");
        rate.setLoanStatus("Rejected - Low salary");
        rate.setLoanRate(999);
    }
}
