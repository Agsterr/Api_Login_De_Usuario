package br.com.agtsoftware.api.exception;

public class UsuarioExistenteException extends RuntimeException{
    public UsuarioExistenteException(String messege) {
        super(messege);
    }
}
