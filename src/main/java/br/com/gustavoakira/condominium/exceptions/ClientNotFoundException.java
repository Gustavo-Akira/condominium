package br.com.gustavoakira.condominium.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String s){
        super("Client not found with id"+s);
    }
}
