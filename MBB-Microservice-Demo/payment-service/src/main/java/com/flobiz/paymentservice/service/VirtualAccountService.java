package com.flobiz.paymentservice.service;

import com.flobiz.paymentservice.model.VirtualAccount;

public interface VirtualAccountService {

    public VirtualAccount getVirtualAccount(String companyId);
    public VirtualAccount createVirtualAccount(VirtualAccount virtualAccount);
}
