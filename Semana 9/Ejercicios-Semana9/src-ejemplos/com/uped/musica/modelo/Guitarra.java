package com.uped.musica.modelo;

public class Guitarra extends Instrumento {
    public String tipo = "cuerda";

    @Override
    public void tocar() {
        System.out.println("Rasgueo de cuerdas");
    }

    public static String identificar() {
        return "Guitarra";
    }
}
