package com.flobiz.platformservice.service;

import com.flobiz.platformservice.dao.CompanyRepository;
import com.flobiz.platformservice.model.Company;
import com.flobiz.platformservice.payload.VirtualAccount;
import com.flobiz.platformservice.proxy.PaymentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PaymentServiceProxy paymentServiceProxy;

    @Override
    public UUID createCompany(Company company) {
        companyRepository.save(company);
        return null;
    }

    @Override
    public Company getCompany(String name) {
        Company c = new Company(name, "asdsa");
        this.createCompany(c);
        Company company = companyRepository.findByNameIs(name).get(0);
        return company;
    }

    @Override
    public VirtualAccount getCompanyDetail(String name) {
        // Creating data for company
        Company c = new Company(name, "asdsa");
        this.createCompany(c);
        Company company = companyRepository.findByNameIs(name).get(0);

        //Call Feign Client to get VA details

        VirtualAccount virtualAccount = paymentServiceProxy.getVirtualAccount(String.valueOf(company.getId()));
        return virtualAccount;
    }
}
