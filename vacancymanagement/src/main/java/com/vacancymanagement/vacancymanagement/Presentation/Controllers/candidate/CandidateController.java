package com.vacancymanagement.vacancymanagement.Presentation.Controllers.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacancymanagement.vacancymanagement.Application.DTO.Candidate.CandidateDTO;
import com.vacancymanagement.vacancymanagement.Application.UseCases.Candidate.CandidateUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateUseCase candidateUseCase;

    @PostMapping("/criar")
    public ResponseEntity<String> create(@Valid @RequestBody CandidateDTO candidate) {
        try {
            candidateUseCase.execute(candidate);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar candidato: " + e.getMessage());
        }
    }
}
