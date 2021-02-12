package br.com.gustavoakira.condominium.exceptions;

public class UnitNotFoundException extends RuntimeException{
    public UnitNotFoundException(String s){
        super("Unit not found exception id "+s);
    }
}
