package com.uped.proyecto.modelo;

public class Estudiante extends Persona {

    private String carnet;
    private String carrera;
    private double promedio;

    public Estudiante(String nombre, String dui, String carnet, String carrera, double promedio) {
        super(nombre, dui);
        this.carnet = carnet;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public void matricular(String materia) {
        System.out.println(carnet + " matriculo: " + materia);
    }

    @Override
    public double calcularBeneficioAnual() {
        return promedio >= 8.5 ? 500.0 : 0.0;
    }

    @Override
    public String toString() {
        return presentarse() + " | " + carrera + " (" + carnet + ")";
    }

    @Override
    public String describirActividad() {
        return "Asiste a actividades académicas.";
    }
}