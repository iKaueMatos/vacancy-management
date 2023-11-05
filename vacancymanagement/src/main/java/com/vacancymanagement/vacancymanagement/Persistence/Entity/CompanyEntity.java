package com.vacancymanagement.vacancymanagement.Persistence.Entity;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Empresa")
public class CompanyEntity {
    
    @Id
    @Column(name = "id_empresa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_empresa")
    private String name;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "website")
    private String website;

    @NotBlank
    @Column(name = "descricao")
    private String description;

    @NotBlank
    @Column(name = "senha")
    private String password;

    @CNPJ
    @NotBlank
    @Column(name = "cnpj")
    private String cnpj;
}
