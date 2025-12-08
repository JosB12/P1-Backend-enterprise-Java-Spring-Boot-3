package com.p1.backend.infrastructure.security;

import com.p1.backend.domain.model.valueobject.HashedPassword;
import com.p1.backend.domain.port.PasswordHasher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
    Implementacion del puerto PasswordHasher usando BCrypt.
    Esta clase pertenece a la infraestructura.
 */
@Component
public class BCryptPasswordHasher implements PasswordHasher {

    private final BCryptPasswordEncoder encoder;

    public BCryptPasswordHasher(){
        this.encoder = new BCryptPasswordEncoder();
    }
    @Override
    public HashedPassword hash(String rawPassword){
        if(rawPassword ==null || rawPassword.isBlank()){
            throw new IllegalArgumentException("Raw passowrd cannot be null or blank");
        }
        String hashed = encoder.encode(rawPassword);
        return HashedPassword.fromHash(hashed);
    }

    @Override
    public boolean matches(String rawPassword, HashedPassword hashedPassword){
        if(rawPassword == null || hashedPassword == null){
            return false;
        }
        return encoder.matches(rawPassword, hashedPassword.getValue());
    }

}
