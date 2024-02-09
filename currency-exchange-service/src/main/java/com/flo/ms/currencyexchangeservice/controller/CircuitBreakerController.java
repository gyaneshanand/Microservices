package com.flo.ms.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "fallbackResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
    public String getSampleApi(){
        logger.info("Sample API call received");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:9000/some-dummy-api", String.class);

        return responseEntity.getBody();
    }

    @GetMapping("sample-api1")
    @RateLimiter(name = "default")
    public String getSampleApi1(){

        logger.info("II Sample API call received");
        return "Hello from sample API 1";
    }

    public String fallbackResponse(Exception exception){
        return "Fallback Response";
    }
}
