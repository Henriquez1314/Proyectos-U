package com.uped.proyecto.modelo;

public class Registro {

    private int contador = 5;
    private String estado;

    {
        contador += 3;
        System.out.println("Bloque de instancia: contador=" + contador);
    }

    public Registro() {
        estado = "LISTO";
        System.out.println("Constructor: estado=" + estado
                + ", contador=" + contador);
    }
}