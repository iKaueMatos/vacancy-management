package com.vacancymanagement.vacancymanagement.Persistence.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UUID;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Candidato")
public class CandidateEntity {
    
    @Id
    @Column(name = "id_candidato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Column(name = "username")
    private String username;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "descricao")
    private String description;

    @NotBlank
    @Column(name = "curriculo_pdf")
    private String curriculum;

    @Column(name = "idade")
    private Integer age;

    @CPF
    @NotBlank
    private String document;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private Date createAt;
}
