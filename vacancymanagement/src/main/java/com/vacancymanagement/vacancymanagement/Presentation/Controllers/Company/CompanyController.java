package com.vacancymanagement.vacancymanagement.Presentation.Controllers.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacancymanagement.vacancymanagement.Application.DTO.Company.CompanyDTO;
import com.vacancymanagement.vacancymanagement.Application.UseCases.Company.CompanyUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/company")
public class CompanyController {
    
    @Autowired
    private CompanyUseCase companyUseCase;

    @PostMapping("/criar")
    public ResponseEntity<String> create(@Valid @RequestBody CompanyDTO companyDTO) {
        try {
            if (companyDTO != null) {
                companyUseCase.execute(companyDTO);
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Empresa registrada com sucesso !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha ao criar a empresa: " + e.getMessage());
        }
    }
}
