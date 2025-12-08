package com.p1.backend.infrastructure.configuration;

import com.p1.backend.application.service.RegisterUserService;
import com.p1.backend.domain.port.PasswordHasher;
import com.p1.backend.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion de Spring para crear los beans de la aplicacion.
 * aqui "conectamos" rodas las capas.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Crea el servicio de aplicacion RegisterUserService.
     * Spring inyecta automaticamente las dependencias.
     */
    @Bean
    public RegisterUserService registerUserService(
            UserRepository userRepository,
            PasswordHasher passwordHasher
    ){
        return new RegisterUserService(userRepository, passwordHasher);
    }
}
