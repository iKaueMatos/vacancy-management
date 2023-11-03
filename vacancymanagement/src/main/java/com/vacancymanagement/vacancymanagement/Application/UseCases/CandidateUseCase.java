package com.vacancymanagement.vacancymanagement.Application.UseCases;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacancymanagement.vacancymanagement.Application.DTO.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Domain.Services.CandidateValidationService;
import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;
import com.vacancymanagement.vacancymanagement.Persistence.Repository.CandidateRespository;

import jakarta.validation.ValidationException;

@Service
public class CandidateUseCase {

    private CandidateRespository candidateRepository;
    
    private CandidateValidationService validationService;

    private ModelMapper modelMapper;

    private CandidateEntity candidateEntity;
    
    @Autowired
    public CandidateUseCase(CandidateRespository candidateRepository, CandidateValidationService validationService, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.validationService = validationService;
        this.modelMapper = modelMapper;
    }

    public CandidateDTO create(CandidateDTO candidateDTO) {
        if (validationService.isValidCandidate(candidateDTO)) {
            candidateEntity = modelMapper.map(candidateDTO, CandidateEntity.class);
            CandidateEntity savedCandidateEntity = candidateRepository.save(candidateEntity);
            CandidateDTO newCandidateDTO = modelMapper.map(savedCandidateEntity, CandidateDTO.class);

            return newCandidateDTO;

        } else {
            throw new ValidationException("Dados do candidato inválidos");
        }
    }
}
