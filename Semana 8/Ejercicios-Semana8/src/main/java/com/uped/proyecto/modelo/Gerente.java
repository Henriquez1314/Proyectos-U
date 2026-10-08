package com.uped.proyecto.modelo;

public class Gerente extends Empleado {

    private int tamanoEquipo;

    public Gerente(String nombre, String dui, double salario, int tamanoEquipo) {
        super(nombre, dui, salario);
        this.tamanoEquipo = tamanoEquipo;
    }

    public int getTamanoEquipo() {
        return tamanoEquipo;
    }

    @Override
    public double calcularBeneficioAnual() {
        return super.calcularBeneficioAnual() + (tamanoEquipo * 25.0);
    }

    @Override
    public String toString() {
        return presentarse() + " | Gerente, equipo de " + tamanoEquipo + " personas";
    }
}