package com.vacancymanagement.vacancymanagement.Application.UseCases.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Domain.Company.Service.CompanyService;
import com.vacancymanagement.vacancymanagement.Domain.Company.Service.CompanyValidationService;

import jakarta.validation.ValidationException;

@Service
public class CompanyUseCase {
    
    @Autowired
    private CompanyService comparnyService;

    @Autowired
    private CompanyValidationService companyValidationService;

    public ResponseEntity<CompanyDTO> execute(CompanyDTO CompanyDTO) {
        if (companyValidationService.isValidCompany(CompanyDTO)) {
            CompanyDTO newCompanyDTO = comparnyService.createCompany(CompanyDTO);

            return new ResponseEntity<>(newCompanyDTO, HttpStatus.OK);
        } else {
            throw new ValidationException("Dados do candidato inválidos");
        }
    }
}
