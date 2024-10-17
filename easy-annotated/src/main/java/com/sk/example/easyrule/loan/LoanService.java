package com.sk.example.easyrule.loan;

import com.sk.example.easyrule.loan.rules.AnnualSalary;
import com.sk.example.easyrule.loan.rules.CreditScore;
import com.sk.example.easyrule.loan.rules.CreditScore650;
import com.sk.example.easyrule.loan.rules.CreditScore750;
import com.sk.example.easyrule.loan.rules.CreditScoreHigh;
import com.sk.example.easyrule.loan.rules.DebtAgainstLoan;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 10/17/2024
 * {@code @authors} shaji
 */
@Service
@Slf4j
public class LoanService {
    @Autowired
    RulesEngine rulesEngine;

    public Rate findRate(Participant participant ){
        log.info("Finding rate");
        Rate rate = new Rate();
        Facts facts = new Facts();
        facts.put("participant", participant);
        facts.put("rate", rate);
        Rules rules = new Rules();
        rules.register(new DebtAgainstLoan());
        rules.register(new AnnualSalary());
        rules.register(new CreditScore());
        rules.register(new CreditScore650());
        rules.register(new CreditScore750());
        rules.register(new CreditScoreHigh());
        rulesEngine.fire(rules, facts);
        return rate;
    }
}
