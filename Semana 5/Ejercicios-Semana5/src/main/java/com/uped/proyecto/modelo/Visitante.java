package com.uped.proyecto.modelo;

public class Visitante extends Persona {

    public Visitante(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Visitante{" + presentarse() + "}";
    }
}