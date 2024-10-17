package com.sk.example.easyrule;

import com.sk.example.easyrule.loan.LoanService;
import com.sk.example.easyrule.loan.Participant;
import com.sk.example.easyrule.loan.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 10/17/2024
 * {@code @authors} shaji
 */
@RestController
@RequestMapping("/")
public class RulesController {
    @Autowired
    LoanService loanService;
    @PostMapping("bankservice/getrate")
    public Rate getRate(@RequestBody Participant participant){
        return loanService.findRate(participant);
    }
}
