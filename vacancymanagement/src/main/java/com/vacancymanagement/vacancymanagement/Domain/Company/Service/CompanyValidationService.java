package com.vacancymanagement.vacancymanagement.Domain.Company.Service;

import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CompanyRespository;

@Service
public class CompanyValidationService {
    
    private CompanyRespository companyRespository;

    public boolean isValidCompany(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            return false;
        }

        if (isNullOrEmpty(companyDTO.getName())) {
            return false;
        }

        return true;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
