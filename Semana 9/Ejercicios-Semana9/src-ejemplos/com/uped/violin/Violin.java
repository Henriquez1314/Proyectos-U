package com.uped.violin;

class Violin extends Instrumento {
    String tipo = "cuerda frotada";

    static String catalogo() {
        return "Catalogo cuerdas";
    }

    @Override
    void tocar() {
        System.out.println("Nota sostenida");
    }
}
