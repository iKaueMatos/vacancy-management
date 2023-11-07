package com.vacancymanagement.vacancymanagement.Domain.Company.Model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CompanyEntity;

@Service
public class CompanyModelMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public CompanyEntity toCompanyDTOAsCompanyEntity(CompanyDTO request) {
        return this.modelMapper.map(request, CompanyEntity.class);
    }

    public CompanyDTO toCandidateDTOResponse(CompanyEntity companyEntity) {
        return this.modelMapper.map(companyEntity, CompanyDTO.class);
    }
}
