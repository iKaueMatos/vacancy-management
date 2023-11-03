package com.vacancymanagement.vacancymanagement.Persistence.Entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "Candidato")
@NoArgsConstructor
public class CandidateEntity {
    
    @Id
    @Column(name = "id_candidato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
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

    @CreationTimestamp
    @Column(name = "data_criacao")
    private Date createAt;
}
