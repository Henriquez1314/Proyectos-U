package com.uped.proyecto.modelo;

public class Docente extends Persona {

    private String especialidad;
    private int añosExperiencia;

    public Docente(String nombre, String dui, String especialidad, int añosExperiencia) {
        super(nombre, dui);
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    public void impartirClase(String materia) {
        System.out.println(nombre + " imparte: " + materia);
    }

    @Override
    public double calcularBeneficioAnual() {
        return añosExperiencia * 45.0;
    }

    @Override
    public String toString() {
        return presentarse() + " | " + especialidad + " (" + añosExperiencia + " años)";
    }

    @Override
    public String describirActividad() {
        return "Imparte clases y actividades educativas.";
    }
}