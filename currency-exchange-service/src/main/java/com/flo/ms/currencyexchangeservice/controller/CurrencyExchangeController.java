package com.flo.ms.currencyexchangeservice.controller;

import com.flo.ms.currencyexchangeservice.dao.CurrencyExchangeRepository;
import com.flo.ms.currencyexchangeservice.model.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    CurrencyExchangeRepository currencyExchangeRepository;

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> getCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to
    )
    {
        logger.info("Retrieve exchange value called with {} to {}", from, to);

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);

        if(currencyExchange == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return new ResponseEntity<CurrencyExchange>(currencyExchange, HttpStatus.OK);
    }
}
