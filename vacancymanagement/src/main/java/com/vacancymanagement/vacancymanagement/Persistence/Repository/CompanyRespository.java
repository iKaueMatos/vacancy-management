package com.vacancymanagement.vacancymanagement.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacancymanagement.vacancymanagement.Persistence.Entity.CompanyEntity;

@Repository
public interface CompanyRespository extends JpaRepository<CompanyEntity, Long> { }