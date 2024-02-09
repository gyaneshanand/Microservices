package com.flo.ms.currencyconversionservice.controller;

import com.flo.ms.currencyconversionservice.model.CurrencyConversion;
import com.flo.ms.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable float quantity
    ) {
        HashMap<String, String> uri_variables = new HashMap<>();
        uri_variables.put("from", from);
        uri_variables.put("to", to);
        ResponseEntity<CurrencyConversion> currency_exchange = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uri_variables);

        CurrencyConversion currencyConversion = currency_exchange.getBody();

        return new CurrencyConversion(currencyConversion.getId(), to, from, currencyConversion.getConversionMultiple(), quantity*currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment()+ " rest template");
    }

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable float quantity)
    {
        CurrencyConversion currencyConversion = currencyExchangeProxy.getCurrencyExchange(from, to);
        return new CurrencyConversion(currencyConversion.getId(), to, from, currencyConversion.getConversionMultiple(), quantity*currencyConversion.getConversionMultiple(), currencyConversion.getEnvironment() + " feign");
    }
}
