package br.com.edsoncosta.webfluxcourse.service.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String message){
        super(message);
    }
}
