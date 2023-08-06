package pl.jakubdrozdz.hibernate.appointment.exception;

public class AppointmentNotFoundException extends Exception{
    public AppointmentNotFoundException(String message){
        super(message);
    }
    public AppointmentNotFoundException(String message, Throwable errorCause){
        super(message, errorCause);
    }
}
