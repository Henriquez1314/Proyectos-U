package com.uped.proyecto.modelo;

import java.time.LocalDate;

public class Suscripcion {

    private String usuario;
    private String plan;
    private LocalDate inicio;
    private int meses;

    public Suscripcion(String usuario, String plan,
                       LocalDate inicio, int meses) {

        if (meses <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad de meses debe ser mayor a cero.");
        }

        this.usuario = usuario;
        this.plan = plan;
        this.inicio = inicio;
        this.meses = meses;
    }

    public Suscripcion(String usuario, String plan, LocalDate inicio) {
        this(usuario, plan, inicio, 1);
    }

    public Suscripcion(String usuario, String plan) {
        this(usuario, plan, LocalDate.now());
    }

    public Suscripcion(String usuario) {
        this(usuario, "GRATIS");
    }

    public static Suscripcion gratuita(String usuario) {
        return new Suscripcion(usuario, "GRATIS");
    }

    public static Suscripcion premium(String usuario) {
        return new Suscripcion(usuario, "PREMIUM");
    }

    @Override
    public String toString() {
        return "Suscripcion{usuario='" + usuario +
                "', plan='" + plan +
                "', inicio=" + inicio +
                ", meses=" + meses + "}";
    }
}