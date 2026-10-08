package com.uped.proyecto.modelo;

public class Cliente extends Persona {

    private String telefono;
    private double comprasAnuales;

    public Cliente(String nombre, String dui, String telefono, double comprasAnuales) {
        super(nombre, dui);
        this.telefono = telefono;
        this.comprasAnuales = comprasAnuales;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public double calcularBeneficioAnual() {
        return comprasAnuales * 0.05;
    }

    @Override
    public String describirActividad() {
        return "Realiza compras en el establecimiento.";
    }
}