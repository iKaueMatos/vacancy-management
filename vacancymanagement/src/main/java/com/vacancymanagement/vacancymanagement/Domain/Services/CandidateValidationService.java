package com.vacancymanagement.vacancymanagement.Domain.Services;

import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.CandidateDTO;

@Service
public class CandidateValidationService {
    
      public boolean isValidCandidate(CandidateDTO candidate) {
        if (candidate == null) {
            return false;
        }

        if (isNullOrEmpty(candidate.name())) {
            return false;
        }

        if (candidate.age() <= 0 || candidate.age() > 120) {
            return false;
        }

        return true;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
