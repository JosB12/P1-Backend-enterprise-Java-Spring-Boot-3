package com.p1.backend.interfaces.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * DTO para la peticion de registro de usuario.
 * Define que campos se esperan en el json.
 *
 * Ejemplo JSON:
 * {
 *     "email" : "jose@example.com",
 *     "name" : "Jose Perez",
 *     "phoneNumber" : "8099199887",
 *     "userName" : "josue",
 *     "password" : "securePass123",
 *     "role" : "USER"
 * }
 */
public class RegisterUserRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "name must be between 2 and 100 characters")
    private String name;

    @Size(max = 20, message = "Phone number cannot exceed 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Pattern(
            regexp = "^[a-zA-Z0-9_-]+$",
            message = "Username can only contain letters, numbers, hyphens and underscores"
    )
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "Role is required")
    @Pattern(
            regexp = "^(USER|ADMIN|MANAGER|SUPERADMIN)$",
            message = "Role must be USER, ADMIN, MANAGER or SUPERADMIN"
    )
    private String role;

    // ========== CONSTRUCTOR VACÍO ==========
    public RegisterUserRequest(){

    }
    // ========== CONSTRUCTOR completo ==========
    public RegisterUserRequest(
        String email,
        String name,
        String phoneNumber,
        String userName,
        String password,
        String role
    ){
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.role = role;
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

    //password
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //role
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
}
