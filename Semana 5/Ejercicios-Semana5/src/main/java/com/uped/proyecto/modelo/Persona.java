package com.uped.proyecto.modelo;

public class Persona {

    protected String nombre;
    protected String dui;

    public Persona(String nombre, String dui) {
        this.nombre = nombre;
        this.dui = dui;
    }

    public Persona(String nombre) {
        this(nombre, "PENDIENTE");
    }

    public String presentarse() {
        return nombre + " (DUI: " + dui + ")";
    }
}