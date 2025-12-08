package com.p1.backend.interfaces.web.dto.response;

import java.time.LocalDateTime;

/**
 * DTO para respuestas de error estandarizadas.
 * Se devuelve cuando ocurre una excepcion.
 */
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(){
        this.timestamp = LocalDateTime.now();
    }
    public ErrorResponse(
            int status,
            String error,
            String message,
            String path
    ){
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
    //=========GETTER y SETTERS =========

    public LocalDateTime getTimesTamp(){
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String getError(){
        return error;
    }
    public void setError(String error){
        this.error = error;
    }
    //message
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    //path
    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
    }
}
