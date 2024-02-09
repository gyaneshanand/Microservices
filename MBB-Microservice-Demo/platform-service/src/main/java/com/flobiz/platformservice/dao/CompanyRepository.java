package com.flobiz.platformservice.dao;

import com.flobiz.platformservice.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    public List<Company> findByNameIs(String name);
}
