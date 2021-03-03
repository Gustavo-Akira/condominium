package br.com.gustavoakira.condominium.exceptions;

public class ForbiddenAccess extends RuntimeException{
    public ForbiddenAccess(){
        super("User not allowed to do this action");
    }
}
