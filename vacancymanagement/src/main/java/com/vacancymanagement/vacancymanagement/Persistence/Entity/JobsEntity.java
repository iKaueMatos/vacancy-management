package com.vacancymanagement.vacancymanagement.Persistence.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Vagas")
public class JobsEntity {
    
    @Id
    @Column(name = "id_vaga")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "descricao")
    private String description;

    @Column(name = "nivel")
    private String level;

    @Column(name = "beneficios")
    private String benefits;

    @ManyToOne
    @JoinColumn(name = "empresa_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "empresa_id")
    private UUID companyId;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime createAt;
}
