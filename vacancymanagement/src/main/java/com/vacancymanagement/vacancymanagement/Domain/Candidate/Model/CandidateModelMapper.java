package com.vacancymanagement.vacancymanagement.Domain.Candidate.Model;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Candidate.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;

@Service
public class CandidateModelMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public CandidateEntity toCandidateDTOAsCandidateEntity(CandidateDTO request) {
        return this.modelMapper.map(request, CandidateEntity.class);
    }

    public CandidateDTO toCandidateDTOResponse(CandidateEntity candidateEntity) {
        return this.modelMapper.map(candidateEntity, CandidateDTO.class);
    }
}
