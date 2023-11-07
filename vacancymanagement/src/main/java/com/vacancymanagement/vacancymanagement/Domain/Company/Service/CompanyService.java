package com.vacancymanagement.vacancymanagement.Domain.Company.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Domain.Company.Model.CompanyModelMapper;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CompanyEntity;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CompanyRespository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRespository companyRespository;

    private CompanyModelMapper companyModelMapper;

    public CompanyService(CompanyRespository companyRespository, CompanyModelMapper companyModelMapper) {
        this.companyModelMapper = companyModelMapper;
        this.companyRespository = companyRespository;
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = companyModelMapper.toCompanyDTOAsCompanyEntity(companyDTO);
        CompanyEntity newCompanySave = companyRespository.save(companyEntity);
        CompanyDTO newCompanyDTO = companyModelMapper.toCandidateDTOResponse(newCompanySave);

        return newCompanyDTO;
    }
}
