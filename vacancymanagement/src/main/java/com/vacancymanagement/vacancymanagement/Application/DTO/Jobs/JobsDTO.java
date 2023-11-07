package com.vacancymanagement.vacancymanagement.Application.DTO.Jobs;

import com.vacancymanagement.vacancymanagement.Persistence.Entity.CompanyEntity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JobsDTO {
    
    @NotBlank
    private String description;

    @NotBlank
    private String level;

    @NotBlank
    private String benefits;

    @NotBlank
    private CompanyEntity companyEntity;
}
