package com.vacancymanagement.vacancymanagement.Domain.Company.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CompanyRespository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRespository candidateRespository;

    /**
     * TODO -> em desenvolvimento
     * @param companyDTO
     * @return
     */
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        return null;
    }
}
