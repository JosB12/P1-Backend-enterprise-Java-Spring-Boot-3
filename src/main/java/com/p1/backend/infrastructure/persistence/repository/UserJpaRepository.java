package com.p1.backend.infrastructure.persistence.repository;

import com.p1.backend.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 Repositorio de Spring Data JPA
 Spring implementa automaticamente los metodos CRUD.
 IMPORTANTE: Esta es una interfaz de Spring, no del dominio.
 */

@Repository
public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {

    /**
     Spring Data genera automaticamente la implementacion
     solo con el nombre del metodo
     */
    Optional<UserJpaEntity> findByEmail(String email);
    Optional<UserJpaEntity> findByUserName(String UserName);
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
}
