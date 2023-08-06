package pl.jakubdrozdz.hibernate.pet.exception;

public class PetNotFoundException extends Exception{
    public PetNotFoundException(String message){
        super(message);
    }
    public PetNotFoundException(String message, Throwable errorCause){
        super(message, errorCause);
    }
}
