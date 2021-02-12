package br.com.gustavoakira.condominium.models.enums;

public enum VehicleType {
    CAR(1L),
    BICYCLE(2L),
    MOTORCYCLE(3L);
    Long id;
    VehicleType(Long id){
        this.id = id;
    }
}
