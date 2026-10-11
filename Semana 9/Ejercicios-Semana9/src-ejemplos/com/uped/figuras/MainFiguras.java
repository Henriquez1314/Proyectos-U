package com.uped.figuras;

public class MainFiguras {

    public static void main(String[] args) {

        Circulo circulo = new Circulo("Circulo", 5);

        System.out.println("Figura: " + circulo.nombre);
        System.out.println("Area: " + circulo.calcularArea());

        if (Math.abs(circulo.calcularArea() - 78.5398) < 0.001) {
            System.out.println("Correcto: el area del circulo de radio 5 es 78.54");
        } else {
            System.out.println("Error: el area calculada no es la esperada");
        }

        System.out.println();
        System.out.println("Figura es abstract, no se puede instanciar:");
        System.out.println("new Figura() no compila: Figura is abstract; cannot be instantiated");
    }
}
