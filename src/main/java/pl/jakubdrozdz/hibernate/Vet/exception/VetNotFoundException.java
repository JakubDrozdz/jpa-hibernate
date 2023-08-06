package pl.jakubdrozdz.hibernate.Vet.exception;

public class VetNotFoundException extends Exception{
    public VetNotFoundException(String message){
        super(message);
    }
    public VetNotFoundException(String message, Throwable errorCause){
        super(message, errorCause);
    }
}
