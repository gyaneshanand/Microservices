package com.flobiz.paymentservice.service;

import com.flobiz.paymentservice.dao.VirtualAccountRepository;
import com.flobiz.paymentservice.model.VirtualAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirtualAccountServiceImpl implements VirtualAccountService {

    @Autowired
    VirtualAccountRepository virtualAccountRepository;

    @Override
    public VirtualAccount getVirtualAccount(String companyId) {
        this.createVirtualAccount(new VirtualAccount(String.valueOf((int)(Math.random()*100))+"3123234","YESB232423WER",companyId));
        return virtualAccountRepository.findByCompanyId(companyId).get(0);
    }

    @Override
    public VirtualAccount createVirtualAccount(VirtualAccount virtualAccount) {
        VirtualAccount v =  virtualAccountRepository.save(virtualAccount);
        return v;
    }
}
