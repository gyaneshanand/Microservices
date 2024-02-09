package com.flo.ms.currencyconversionservice.proxy;

import com.flo.ms.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyExchangeProxy {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to
    );

}
