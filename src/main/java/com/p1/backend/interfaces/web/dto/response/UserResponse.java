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
    private String role;
    private String status;
    private boolean verified;
}
