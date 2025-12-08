package com.p1.backend.interfaces.web.dto.response;

import java.util.UUID;

/**
 * DTO para la respuesta con datos de usuario.
 * define que campos se devuelven en el JSON.
 *
 * IMPORTANTE: No incluye el password (por motivos de seguridad).
 *
 * Ejemplo JSON:
 * {
 *   "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
 *   "email": "jose@example.com",
 *   "name": "José Pérez",
 *   "phoneNumber": "8095551234",
 *   "userName": "josue",
 *   "role": "USER",
 *   "status": "ACTIVE",
 *   "verified": false
 */

public class UserResponse {
    private UUID id;
    private String email;
    private String name;
    private String phoneNumber;
    private String userName;
    private String role;
    private String status;
    private boolean verified;

    // ========== CONSTRUCTOR VACÍO ==========
    public UserResponse(){

    }
    // ========== CONSTRUCTOR COMPLETO ==========

    public UserResponse(
            UUID id,
            String email,
            String name,
            String phoneNumber,
            String userName,
            String role,
            String status,
            boolean verified
    ){
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.role = role;
        this.status = status;
        this.verified = verified;
    }

    //===========GETTERS Y SETTERS ===========

    //id
    public UUID getId(){
        return id;
    }
    public void setId(UUID id){
        this.id = id;
    }

    //email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //phoneNumber
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    //userName
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    //role
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    //status
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    //verified
    public boolean isVerified(){
        return verified;
    }
    public void setVerified(boolean verified){
        this.verified = verified;
    }
}
