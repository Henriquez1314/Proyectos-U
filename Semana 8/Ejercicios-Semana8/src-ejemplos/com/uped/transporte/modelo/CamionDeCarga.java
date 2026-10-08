package com.uped.transporte.modelo;

public class CamionDeCarga extends Vehiculo {

    private static final double TARIFA_KM = 0.08;
    private static final double RECARGO_FIJO = 15.00;

    public CamionDeCarga(String placa,
            double kilometrosRecorridos) {
        super(placa, kilometrosRecorridos);
    }

    @Override
    public double calcularCostoPeaje() {
        return (kilometrosRecorridos * TARIFA_KM)
            + RECARGO_FIJO;
    }
}
