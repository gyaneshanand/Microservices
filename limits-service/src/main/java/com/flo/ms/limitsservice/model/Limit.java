package com.flo.ms.limitsservice.model;

import org.springframework.context.annotation.Bean;


public class Limit {

    private int min_limit;
    private int max_limit;

    public Limit() {
    }

    public Limit(int min_limit, int max_limit) {
        this.min_limit = min_limit;
        this.max_limit = max_limit;
    }

    public int getMin_limit() {
        return min_limit;
    }

    public void setMin_limit(int min_limit) {
        this.min_limit = min_limit;
    }

    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }
}
