package br.com.gustavoakira.condominium.exceptions;

public class VehicleNotFoundException extends RuntimeException{
    public VehicleNotFoundException(String s){
        super("Vehicle not found with id "+s);
    }
}
