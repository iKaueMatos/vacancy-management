package com.vacancymanagement.vacancymanagement.Persistence.Repository;

import org.modelmapper.internal.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;

@Repository
public interface CandidateRespository extends JpaRepository<CandidateEntity, Long> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
