package com.uped.proyecto.modelo;

public class Pedido {

    private int numero;
    private double total = 0.0;
    private String estado;

    {
        estado = "CREADO";
        System.out.println("2) Bloque instancia");
    }

    public Pedido(int numero) {
        this.numero = numero;
        System.out.println("3) Constructor, estado=" + estado);
    }

    public int getNumero() {
        return numero;
    }
}