package com.vacancymanagement.vacancymanagement.Presentation.Controllers.Jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vacancymanagement.vacancymanagement.Application.DTO.Jobs.JobsDTO;
import com.vacancymanagement.vacancymanagement.Application.UseCases.Jobs.JobsUseCase;

import jakarta.validation.Valid;

public class JobsController {
    
    @Autowired
    private JobsUseCase jobsUseCase;

    @PostMapping("/criar")
    public ResponseEntity<String> create(@Valid @RequestBody JobsDTO jobsDTO) {
        try {
            if (jobsDTO != null) {
                jobsUseCase.execute(jobsDTO);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Vaga registrada com sucesso !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar a empresa: " + e.getMessage());
        }
    }
}
