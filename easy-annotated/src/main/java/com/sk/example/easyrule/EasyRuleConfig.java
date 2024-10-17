package com.sk.example.easyrule;

import com.sk.example.easyrule.loan.rules.DebtAgainstLoan;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 10/17/2024
 * {@code @authors} shaji
 */
@Configuration
public class EasyRuleConfig {
    @Bean
    public RulesEngine rulesEngine(){
        RulesEngineParameters parameters = new RulesEngineParameters()
                .skipOnFirstAppliedRule(true);
        return new DefaultRulesEngine(parameters);
    }
}
