package br.com.gustavoakira.condominium.exceptions;

public class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(String s){
        super("Animal not found with id " +s);
    }
}
