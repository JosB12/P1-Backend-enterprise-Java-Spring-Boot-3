package com.p1.backend.infrastructure.persistence.adapter;

import com.p1.backend.domain.model.User;
import com.p1.backend.domain.model.UserRole;
import com.p1.backend.domain.model.UserStatus;
import com.p1.backend.domain.model.valueobject.Email;
import com.p1.backend.domain.model.valueobject.HashedPassword;
import com.p1.backend.domain.model.valueobject.UserName;
import com.p1.backend.domain.repository.UserRepository;
import com.p1.backend.infrastructure.persistence.entity.UserJpaEntity;
import com.p1.backend.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * Adaptador que implementa el puerto UserRepository del dominio.
 * Convierte entre entidades de dominio (User) y entidades JPA (UserJpaEntity)
 *
 * Esta clase es el Puente entre el dominio y la infraestructura
 */

@Component
public class UserRepositoryAdapter implements UserRepository{

    private final UserJpaRepository jpaRepository;

    public UserRepositoryAdapter(
            UserJpaRepository jpaRepository
    ){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findById(UUID id){
        return jpaRepository.findById(id)
                .map(this::toDomain);
    }
    @Override
    public Optional<User> findByEmail(String email){
        return jpaRepository.findByEmail(email)
                .map(this::toDomain);
    }
    @Override
    public Optional<User> findByUserName(String userName){
        return jpaRepository.findByUserName(userName)
                .map(this::toDomain);
    }
    @Override
    public boolean existsByEmail (String email){
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String userName){
        return jpaRepository.existsByUserName(userName);
    }
    @Override
    public User save(User user){
        UserJpaEntity jpaEntity = toJpaEntity(user);
        UserJpaEntity saved = jpaRepository.save(jpaEntity);
        return toDomain(saved);
    }

    //================MAPPERS (CONVERSORES)================

    /**
     * Convierte de User (dominio) a UserJpaEntity (infraestructure)
     */
    private UserJpaEntity toJpaEntity(User user){
        return new UserJpaEntity(
                user.getId(),
                user.getEmail().getValue(),
                user.getName(),
                user.getPhoneNumber(),
                user.getRole().name(),
                user.getStatus().name(),
                user.isVerified(),
                user.getUserName().getValue(),
                user.getPassword().getValue()
        );
    }

    /**
     *Convierte de UserJpaEntity (infraestructura) a User (domain)
     */
    private User toDomain(UserJpaEntity entity){
        return new User(
                entity.getId(),
                Email.of(entity.getEmail()),
                entity.getName(),
                entity.getPhoneNumber(),
                UserStatus.valueOf(entity.getStatus()),
                entity.isVerified(),
                UserRole.valueOf(entity.getRole()),
                UserName.of(entity.getUserName()),
                HashedPassword.fromHash(entity.getPassword())
        );
    }
}
