package com.vacancymanagement.vacancymanagement.Domain.Model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vacancymanagement.vacancymanagement.Application.DTO.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;

@Component
public class CandidateModelMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public CandidateEntity toCandidateDTOAsCandidateEntity(CandidateDTO request) {
        return modelMapper.map(request, CandidateEntity.class);
    }

    public CandidateDTO toCandidateDTOResponse(CandidateEntity candidateEntity) {
        return modelMapper.map(candidateEntity, CandidateDTO.class);
    }
}
