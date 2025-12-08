package com.p1.backend.interfaces.web.mapper;

import com.p1.backend.domain.model.User;
import com.p1.backend.interfaces.web.dto.response.UserResponse;
import org.springframework.stereotype.Component;

/**
 * Mapper para convertir entre entidades de dominio y DTOs.
 * Separa la representacion interna (dominio) de la externa (API)
 */
@Component
public class UserMapper {

    /**
     * Convierte User (Dominio) a UserResponse (DTO)
     *
     * IMPORTANTE: No incluye el password en la respuesta
     */
    public UserResponse toResponse(User user){
        if(user == null){
            return null;
        }
        return new UserResponse(
                user.getId(),
                user.getEmail().getValue(),
                user.getName(),
                user.getPhoneNumber(),
                user.getUserName().getValue(),
                user.getRole().name(),
                user.getStatus().name(),
                user.isVerified()
        );
    }
}
