package com.vacancymanagement.vacancymanagement.Persistence.Repository;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vacancymanagement.vacancymanagement.Persistence.Entity.CandidateEntity;

@Repository
public interface CandidateRespository extends JpaRepository<CandidateEntity, UUID> {

    @Query("SELECT c FROM CandidateEntity c WHERE c.username = :username OR c.email = :email")
    java.util.Optional<CandidateEntity> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
}
