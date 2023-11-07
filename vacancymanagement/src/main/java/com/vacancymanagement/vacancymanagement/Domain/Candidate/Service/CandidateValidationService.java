package com.vacancymanagement.vacancymanagement.Domain.Candidate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Candidate.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CandidateRespository;

@Service
public class CandidateValidationService {
    
    @Autowired
    private CandidateRespository candidateRespository;

    public boolean isValidCandidate(CandidateDTO candidate) {
        if (candidate == null) {
            return false;
        }
    
        if (isNullOrEmpty(candidate.getName())) {
            return false;
        }
    
        if (candidate.getAge() <= 0 || candidate.getAge() > 120) {
            return false;
        }
    
        return true;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
