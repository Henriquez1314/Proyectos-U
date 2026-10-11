package com.uped.violin;

class Instrumento {
    String tipo = "generico";

    Instrumento() {
        System.out.println("Construyendo: " + resumen());
    }

    final String resumen() {
        return "tipo=" + tipo;
    }

    static String catalogo() {
        return "Catalogo base";
    }

    void tocar() {
        System.out.println("...generico...");
    }
}
