package com.vacancymanagement.vacancymanagement.Domain.Candidate.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.vacancymanagement.vacancymanagement.Application.DTO.Candidate.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Domain.Candidate.Model.CandidateModelMapper;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CandidateRespository;

public class CandidateService {
    
    @Autowired
    private CandidateRespository candidateRepository;
    private CandidateModelMapper candidateModelMapper;

    public CandidateDTO createCandidate(CandidateDTO candidateDTO) {
        CandidateEntity candidateEntity = candidateModelMapper.toCandidateDTOAsCandidateEntity(candidateDTO);
        CandidateEntity savedCandidateEntity = candidateRepository.save(candidateEntity);
        CandidateDTO newCandidateDTO = candidateModelMapper.toCandidateDTOResponse(savedCandidateEntity);

        return newCandidateDTO;
    }
}
