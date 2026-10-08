package com.uped.transporte.modelo;

public class Motocicleta extends Vehiculo {

    private static final double TARIFA_KM = 0.02;

    public Motocicleta(String placa,
            double kilometrosRecorridos) {
        super(placa, kilometrosRecorridos);
    }

    @Override
    public double calcularCostoPeaje() {
        return kilometrosRecorridos * TARIFA_KM;
    }
}
