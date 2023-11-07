package com.vacancymanagement.vacancymanagement.Application.DTO.Company;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

@Data
public class CompanyDTO {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String username;

    @NotBlank
    private String website;
    
    @NotBlank
    private String description;
    
    @NotBlank
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Flag.UNICODE_CASE)
    @Min(value = 8, message = "Senha invalida porfavor coloque no minimo 8 carácteres")
    private String password;
    
    @NotBlank
    private String cnpj;
}
