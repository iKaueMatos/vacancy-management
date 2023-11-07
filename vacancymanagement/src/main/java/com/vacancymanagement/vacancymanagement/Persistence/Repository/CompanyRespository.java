package com.vacancymanagement.vacancymanagement.Persistence.Repository;

import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacancymanagement.vacancymanagement.Persistence.Entity.CompanyEntity;

@Repository
public interface CompanyRespository extends JpaRepository<CompanyEntity, UUID> { 

    Optional<CompanyEntity> findByUsernameOrCnpj(String username, String cnpj);
}