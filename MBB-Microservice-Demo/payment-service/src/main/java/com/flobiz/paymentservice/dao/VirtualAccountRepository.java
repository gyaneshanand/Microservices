package com.flobiz.paymentservice.dao;

import com.flobiz.paymentservice.model.VirtualAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VirtualAccountRepository extends JpaRepository<VirtualAccount, UUID> {

    public List<VirtualAccount> findByCompanyId(String companyId);
}
