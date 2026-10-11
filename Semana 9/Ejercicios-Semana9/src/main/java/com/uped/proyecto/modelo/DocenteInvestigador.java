package com.uped.proyecto.modelo;

public class DocenteInvestigador extends Docente {

    private int numeroPublicaciones;

    public DocenteInvestigador(String nombre, String dui, String especialidad,
                               int aniosExperiencia, int numeroPublicaciones) {
        super(nombre, dui, especialidad, aniosExperiencia);
        this.numeroPublicaciones = numeroPublicaciones;
    }

    public int getNumeroPublicaciones() {
        return numeroPublicaciones;
    }

    @Override
    public double calcularBeneficioAnual() {
        return super.calcularBeneficioAnual() + (numeroPublicaciones * 30.0);
    }

    @Override
    public String toString() {
        return presentarse() + " | Investigador, " + numeroPublicaciones + " publicaciones";
    }
}