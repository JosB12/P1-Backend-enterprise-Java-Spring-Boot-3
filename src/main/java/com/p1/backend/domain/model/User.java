package com.p1.backend.domain.model;

import com.p1.backend.domain.model.valueobject.Email;
import com.p1.backend.domain.model.valueobject.HashedPassword;
import com.p1.backend.domain.model.valueobject.UserName;

import java.util.Objects;
import java.util.UUID;

/**
 * Entidad agregado raiz del dominio User.
 * Representa un usuario del sistema con sus reglas de negocio
 */
public class User {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 100;

    private final UUID id;
    private Email email;
    private String name;
    private String phoneNumber;
    private UserRole role;
    private UserStatus status;
    private boolean verified;
    private UserName userName;
    private HashedPassword password;

    /**
     * Constructor principal para CREAR nuevos usuarios.
     * Genera un UUID automaticamente y establece estado inicial.
     */
    public User(
            Email email,
            String name,
            String phoneNumber,
            UserRole role,
            UserName userName,
            HashedPassword password
    ){
        this.id = UUID.randomUUID();
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.name = validateAndSetName(name);
        this.phoneNumber = phoneNumber;
        this.role = Objects.requireNonNull(role, "Role cannot be null");
        this.userName = Objects.requireNonNull(userName, "Username cannot be null");
        this.password = Objects.requireNonNull(password, "Password cannot be null");

        this.status = UserStatus.ACTIVE;
        this.verified = false;
    }
    /**
     * constructor para reconstruir usuarios desde la base de datos.
     * Usado por los adaptadores de persistencia.
     */
    public User(
            UUID id,
            Email email,
            String name,
            String phoneNumber,
            UserStatus status,
            boolean verified,
            UserRole role,
            UserName userName,
            HashedPassword password
    ){
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.verified = verified;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    // ============ validaciones privadas ===========
    private String validateAndSetName(String name){
        Objects.requireNonNull(name, "Name cannot be null");
        String trimmed = name.trim();

        if(trimmed.length() <MIN_NAME_LENGTH){
            throw new IllegalArgumentException(
                    "Name must be at least " + MIN_NAME_LENGTH + " characters"
            );
        }

        if(trimmed.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("Name cannot exceed " + MAX_NAME_LENGTH + "characters");
        }
    return trimmed;
    }

    //============= METODOS DE DOMINIO =====================
    /**
     * Marca al usuario como verificado.
     */
    public void verify(){
        this.verified = true;
    }

    /**
     * cambia estado del usuario
     */
    public void changeStatus(UserStatus newStatus){
        this.status = Objects.requireNonNull(newStatus, "Status cannot be null");
    }

    /**
     * Actuliza el password del usuario
     * IMPORTANTE: debe recibir un password ya hasheado.
     */
    public void updatePassword(HashedPassword newPassword){
        this.password = Objects.requireNonNull(newPassword, "Password cannot be null");
    }
    /**
     * Actualizar el perfil del usuario.
     */
    public void updateProfile(String newName, String newPhoneNumber){
        this.name = validateAndSetName(newName);
        this.phoneNumber = newPhoneNumber;
    }
    /**
     * Actualiza el email del usuario
     * al cambiar email, se requiere re-verificacion.
     */
    public void updateEmail(Email newEmail){
        this.email = Objects.requireNonNull(newEmail, "Email cannot be null");
        this.verified = false;
    }
    // ===== GETTERS ======
    public UUID getId(){
        return id;
    }
    public Email getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public UserStatus getStatus(){
        return status;
    }
    public UserRole getRole(){
        return role;
    }
    public boolean isVerified(){
        return verified;
    }
    public UserName getUserName(){
        return userName;
    }
    public HashedPassword getPassword(){
        return password;
    }
}

