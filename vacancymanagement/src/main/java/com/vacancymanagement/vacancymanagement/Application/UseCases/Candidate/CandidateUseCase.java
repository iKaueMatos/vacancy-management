package com.vacancymanagement.vacancymanagement.Application.UseCases.Candidate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.Candidate.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Domain.Candidate.Service.CandidateService;
import com.vacancymanagement.vacancymanagement.Domain.Candidate.Service.CandidateValidationService;

import jakarta.validation.ValidationException;

@Service
public class CandidateUseCase {

    private CandidateValidationService validationService;
    private CandidateService candidateService;

    public CandidateUseCase(CandidateValidationService validationService, CandidateService candidateService) {
        this.validationService = validationService;
        this.candidateService = candidateService;
    }

    public ResponseEntity<CandidateDTO> execute(CandidateDTO candidateDTO) {
        if (validationService.isValidCandidate(candidateDTO)) {
            CandidateDTO newCandidateDTO = candidateService.createCandidate(candidateDTO);

            return new ResponseEntity<>(newCandidateDTO, HttpStatus.OK);
        } else {
            throw new ValidationException("Dados do candidato inválidos");
        }
    }
}

