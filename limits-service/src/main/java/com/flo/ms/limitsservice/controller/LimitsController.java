package com.flo.ms.limitsservice.controller;

import com.flo.ms.limitsservice.config.Configuration;
import com.flo.ms.limitsservice.model.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public Limit getLimits()
    {
        return new Limit(configuration.getMin_limit() ,configuration.getMax_limit());
        //return new Limit(1,1000);
    }
}
