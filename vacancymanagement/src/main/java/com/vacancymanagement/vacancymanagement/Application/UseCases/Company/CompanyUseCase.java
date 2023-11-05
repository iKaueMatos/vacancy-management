package com.vacancymanagement.vacancymanagement.Application.UseCases.Company;

import org.springframework.beans.factory.annotation.Autowired;

import com.vacancymanagement.vacancymanagement.Domain.Company.Service.CompanyService;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CompanyRespository;

public class CompanyUseCase {
    
    @Autowired
    private CompanyRespository companyRespository;

    @Autowired
    private CompanyService comparnyService;
}
