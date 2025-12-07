package com.p1.backend.application.service;

import com.p1.backend.domain.model.User;
import com.p1.backend.domain.model.UserRole;
import com.p1.backend.domain.model.valueobject.Email;
import com.p1.backend.domain.model.valueobject.HashedPassword;
import com.p1.backend.domain.model.valueobject.UserName;
import com.p1.backend.domain.port.PasswordHasher;
import com.p1.backend.domain.repository.UserRepository;

import java.util.Objects;

/**
 * Servicio de aplicacion que orquesta el caso de uso de requistro de usuarios.
 * Coordina entre el dominio y los puestos de infraestructura.
 */
public class RegisterUserService {
  private final UserRepository userRepository;
  private final PasswordHasher passwordHasher;

  public RegisterUserService(
          UserRepository userRepository,
          PasswordHasher passwordHasher
  ){
      this.userRepository = Objects.requireNonNull(
              userRepository,
              "UserRepository cannot be null"
      );
      this.passwordHasher = Objects.requireNonNull(
              passwordHasher,
              "PassowrdHasher cannot be null"
      );
  }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    public User register(
        String email,
        String name,
        String phoneNumber,
        String userName,
        String rawPassword,
        UserRole role
    ){
        //Validacion 1: password longitud minima
        if(rawPassword == null || rawPassword.isBlank()){
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if(rawPassword.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

    // crear value Objects (Validan formato automaticamente)
    Email emailVo = Email.of(email);
    UserName userNameVo = UserName.of(userName);

    // validacion 2: Email unico (requiere BD)
    if(userRepository.existsByEmail(emailVo.getValue())){
        throw new IllegalArgumentException("Email is already registered");
    }

    //validacion 3: username unico (requiere BD)
    if(userRepository.existsByUsername(userNameVo.getValue())){
        throw new IllegalArgumentException("Username is already taken");
    }

    //Hash del password usando el puerto
    HashedPassword hashedPassword = passwordHasher.hash(rawPassword);

    //crear usuario usando el dominio
    User user = new User(
            emailVo,
            name,
            phoneNumber,
            role,
            userNameVo,
            hashedPassword
    );
    //persistir y retornar
    return userRepository.save(user);






    }

}
