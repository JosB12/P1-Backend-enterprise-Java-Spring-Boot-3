package com.p1.backend.domain.repository;

import com.p1.backend.domain.model.User;
import com.p1.backend.domain.model.valueobject.Email;

import java.util.Optional;
import java.util.UUID;

/**
 * Puerto (Interfaz) para el repositorio de usuarios.
 * Define las operaciones de persistencia que necesita el dominio.
 */
public interface UserRepository {

    /**
     * Busca un usuario por su id
     */
    Optional<User> findById(UUID id);

    /**
     * Busca un usuario por su email.
     */
    Optional<User>findByEmail(Email email);

    /**
     * Busca un usuario por su username
     */
    Optional<User> findByUserName(String userName);

    /**
     * Verifica si existe un usuario con el email dado
     */
    boolean existsByEmail(String email);

    /**
     * Verifica si existe un usuario con el username dado
     */
    boolean existsByUsername(String userName);

    /**
     * Guarda o actualiza un usuario
     */
    User save(User user);
}
