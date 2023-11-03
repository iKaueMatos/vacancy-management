package com.vacancymanagement.vacancymanagement.Application.UseCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Domain.Model.CandidateModelMapper;
import com.vacancymanagement.vacancymanagement.Domain.Services.CandidateValidationService;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CandidateRespository;

import jakarta.validation.ValidationException;

@Service
public class CandidateUseCase {

    private CandidateRespository candidateRepository;
    private CandidateValidationService validationService;
    private CandidateModelMapper candidateModelMapper;

    @Autowired
    public CandidateUseCase(
        CandidateRespository candidateRepository,
        CandidateValidationService validationService,
        CandidateModelMapper candidateModelMapper
    ) {
        this.candidateRepository = candidateRepository;
        this.validationService = validationService;
        this.candidateModelMapper = candidateModelMapper;
    }

    public CandidateDTO execute(CandidateDTO candidateDTO) {
        if (validationService.isValidCandidate(candidateDTO)) {
            CandidateEntity candidateEntity = candidateModelMapper.toCandidateDTOAsCandidateEntity(candidateDTO);
            CandidateEntity savedCandidateEntity = candidateRepository.save(candidateEntity);
            CandidateDTO newCandidateDTO = candidateModelMapper.toCandidateDTOResponse(savedCandidateEntity);

            return newCandidateDTO;
        } else {
            throw new ValidationException("Dados do candidato inválidos");
        }
    }
}

