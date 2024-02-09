package com.flobiz.paymentservice.controller;

import com.flobiz.paymentservice.model.VirtualAccount;
import com.flobiz.paymentservice.service.VirtualAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment-service")
public class PaymentController {

    @Autowired
    VirtualAccountService virtualAccountService;

    @GetMapping("/virtual_account")
    public VirtualAccount getVirtualAccount(@RequestParam String companyId){
        return virtualAccountService.getVirtualAccount(companyId);
    }
}
