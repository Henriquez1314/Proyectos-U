package com.uped.transporte.modelo;

public abstract class Vehiculo {

    protected String placa;
    protected double kilometrosRecorridos;

    public Vehiculo(String placa,
              double kilometrosRecorridos) {
        this.placa = placa;
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    // Metodo abstracto: cada subclase define su propia
    // formula de peaje
    public abstract double calcularCostoPeaje();

    // Metodo concreto y final: igual para todo vehiculo,
    // no debe sobrescribirse
    public final void mostrarFicha() {
        System.out.println("Placa: " + placa
            + " | Km recorridos: " + kilometrosRecorridos);
    }
}
