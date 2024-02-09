package com.flobiz.paymentservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class VirtualAccount {

    @Id
    @GeneratedValue
    private UUID id;
    private String accountNumber;
    private String ifsc;
    private String companyId;

    public VirtualAccount() {
    }

    public VirtualAccount(String accountNumber, String ifsc, String companyId) {
        this.accountNumber = accountNumber;
        this.ifsc = ifsc;
        this.companyId = companyId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}