package com.p1.backend.domain.model.valueobject;

import java.util.Objects;

/**
 * Value Object que representa un username valido.
 * Inmutable y con validaciones de formato.
 */
public final class UserName {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 50;
    private static final String VALID_PATTERN = "^[a-zA-Z0-9_-]+$";

    private final String value;

    private UserName(String value){
        String trimmed = value.trim();
        if(trimmed.length() < MIN_LENGTH){
            throw new IllegalArgumentException(
                    "Username must be at least " + MIN_LENGTH + " characters"
            );
        }
        if(trimmed.length() >MAX_LENGTH){
            throw new IllegalArgumentException(
                    "Username cannot exceed " + MAX_LENGTH + " characters"
            );
        }
        this.value = trimmed.toLowerCase();
    }
    /**
     * Factory method para crear un UserName.
     */
    public static UserName of(String value){
        Objects.requireNonNull(value, "Username cannot be null");
        return new UserName(value);
    }
    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(value, userName.value);
    }
    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
    @Override
    public String toString(){
        return value;
    }
}
