package com.flobiz.platformservice.service;

import com.flobiz.platformservice.model.Company;
import com.flobiz.platformservice.payload.VirtualAccount;

import java.util.UUID;

public interface CompanyService {

    public UUID createCompany(Company company);
    public Company getCompany(String name);

    public VirtualAccount getCompanyDetail(String name);
}
