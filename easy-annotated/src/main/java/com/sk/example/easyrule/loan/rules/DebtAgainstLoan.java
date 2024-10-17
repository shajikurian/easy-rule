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
@Rule(name = "Debt against loan", description = "Checking Existing Debt Against Loan Amount", priority = 1)
public class DebtAgainstLoan {
    @Condition
    public boolean when(@Fact("participant")Participant participant){
        return participant.getLoanAmount() > (2* participant.getExistingDebt());
    }

    @Action
    public void then(@Fact("rate")Rate rate){
        log.info("taking action based on debt");
        rate.setLoanStatus("Rejected - Too Much Debt");
        rate.setLoanRate(999);
    }
}
