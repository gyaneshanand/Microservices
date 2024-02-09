package com.flobiz.platformservice.proxy;

import com.flobiz.platformservice.payload.VirtualAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PAYMENT-SERVICE")
public interface PaymentServiceProxy {

    @GetMapping("payment-service/virtual_account")
    public VirtualAccount getVirtualAccount(@RequestParam String companyId);
}
