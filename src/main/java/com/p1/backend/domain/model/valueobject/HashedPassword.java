package com.p1.backend.domain.model.valueobject;

import java.util.Objects;

/**
 * Value Object que representa un password ya hasheado.
 * Garantiza que nunca se almacene un password en texto plano.
 * Inmutable.
 */
public final class HashedPassword {

    private final String value;

    private HashedPassword(String hashedValue){
        if(hashedValue == null || hashedValue.isBlank()){
            throw new IllegalArgumentException("Hashed password cannot be null or blank");
        }
        if(hashedValue.length() <20){
            throw new IllegalArgumentException("Invalid hashed password format");
        }
        this.value = hashedValue;
    }
    /**
     * Factory method para crear un HashedPassword desde un hash.
     */
    public static HashedPassword fromHash(String hashedValue){
        return new HashedPassword(hashedValue);
    }
    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashedPassword that = (HashedPassword) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
    @Override
    public String toString(){
        return "HashedPassword{[PROTECTED]}";
    }
}
