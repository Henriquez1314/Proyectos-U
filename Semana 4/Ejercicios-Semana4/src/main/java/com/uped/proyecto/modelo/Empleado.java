package com.uped.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

    private String nombre;
    private final List<String> tareas;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public List<String> getTareas() {
        return tareas;
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
    }

    public void calcularPlanilla() {
        System.out.println("Calculando planilla de " + nombre);
    }

    public void generarReporte() {
        System.out.println("Generando reporte de " + nombre);
    }
}