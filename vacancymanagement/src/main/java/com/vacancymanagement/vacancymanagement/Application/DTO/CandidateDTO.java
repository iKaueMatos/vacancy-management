package com.vacancymanagement.vacancymanagement.Application.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.Data;

@Data
public class CandidateDTO {

    @NotNull
    private String name;
    
    @NotNull
    private String username;
    
    @Email
    @NotNull
    private String email;
    
    @NotNull
    private String description;
    
    @NotNull
    private String curriculum;
    
    @NotNull
    @Min(value = 18, message = "A idade deve ser maior ou igual a 0")
    private Integer age;

    @NotNull
    @Pattern(regexp = "^(?=.*\\d).{4,8}$", flags = Flag.UNICODE_CASE)
    @Min(value = 8, message = "Senha invalida porfavor coloque no minimo 8 carácteres")
    private String password;
}
