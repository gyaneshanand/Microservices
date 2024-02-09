package com.flo.ms.currencyconversionservice.model;

public class CurrencyConversion {

    private long id;
    private String to;
    private String from;
    private float conversionMultiple;
    private float totalCalculatedAmount;
    private String environment;

    public CurrencyConversion() {
    }

    public CurrencyConversion(long id, String to, String from, float conversionMultiple, float totalCalculatedAmount, String environment) {
        this.id = id;
        this.to = to;
        this.from = from;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public float getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(float conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public float getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(float totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
