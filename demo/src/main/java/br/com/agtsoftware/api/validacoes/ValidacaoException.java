package br.com.agtsoftware.api.validacoes;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String messege){
        super(messege);
    }
}
