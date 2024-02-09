package com.flo.ms.currencyconversionservice.model;

public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getPersonAgeGroup()
    {
        return this.age*2;
    }

    public int getSome()
    {
        return this.getPersonAgeGroup();
    }

}
