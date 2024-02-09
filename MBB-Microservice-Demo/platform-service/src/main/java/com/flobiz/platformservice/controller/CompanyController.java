package com.flobiz.platformservice.controller;

import com.flobiz.platformservice.model.Company;
import com.flobiz.platformservice.payload.VirtualAccount;
import com.flobiz.platformservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("platform-service")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/company")
    public Company getCompany(@RequestParam String name){
        return companyService.getCompany(name);
    }

    @GetMapping("/company_detail")
    public VirtualAccount getCompanyDetail(@RequestParam String name){
        return companyService.getCompanyDetail(name);
    }
}
