package com.p1.backend.domain.port;

import com.p1.backend.domain.model.valueobject.HashedPassword;

/**
 * puerto (interfaz) para el servicio de hashing de passwords.
 * La infraestructura implementara este contrato usando BCript, Argon2, etc.
 */
public interface PasswordHasher {
    /**
     * Hashea un password en texto plano
     */
    HashedPassword hash(String rawPassword);

    /**
     * Verifica si un password raw coincide con un hash.
     */
    boolean matches(String rawPassword, HashedPassword hashedPassword);
}
