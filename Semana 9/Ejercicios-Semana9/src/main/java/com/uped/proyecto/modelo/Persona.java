package com.uped.proyecto.modelo;

public abstract class Persona {

    protected String nombre;
    protected String dui;

    public Persona(String nombre, String dui) {
        this.nombre = nombre;
        this.dui = dui;
    }

    public String presentarse() {
        return nombre + " (DUI: " + dui + ")";
    }

    public abstract double calcularBeneficioAnual();

    public abstract String describirActividad();
}