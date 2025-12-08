package com.p1.backend.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

/**
 Entidad JPA que representa la tabla "users" en la base de datos.
 Esta clase es parte de la infraestructura, no del dominio.

 Importante esta no es la entidad del dominio (User.java).
 Es solo la representacion de como se guarda en la base de datos.
 */
@Entity
@Table(name = "users")
public class UserJpaEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phoneNumber", length = 20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "verified", nullable = false)
    private boolean verified;

    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String userName;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    //==========================CONSTRUCTOR VACIO (REQUERIDO POR JPA)==========================
    public UserJpaEntity(){
        //JPA necesita un constructor sin parametros
    }

    //==========================CONSTRUCTOR COMPLETO==========================
    public UserJpaEntity(
        UUID id,
        String email,
        String name,
        String phoneNumber,
        String role,
        String status,
        boolean verified,
        String userName,
        String password
    ){
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.status = status;
        this.verified = verified;
        this.userName = userName;
        this.password = password;
    }

    //===================== GGETTERS Y SETTERS ======================

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

    //username
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    //password
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
