package semana12.ejercicios.ej8;

import semana12.biblioteca.*;

public class MainEj8 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 8: RETO TODO JUNTO ===");

        Biblioteca bib = new Biblioteca();
        Material m = new Libro("Algoritmos");
        Libro l = (Libro) m;

        System.out.println("\n--- Sobrecarga ---");
        bib.registrar(m);
        bib.registrar(l);

        System.out.println("\n--- Sobrescritura ---");
        System.out.println("describir(): " + m.describir());
        System.out.println("diasPrestamo(): " + m.diasPrestamo());

        System.out.println("\n--- instanceof y cast ---");
        if (m instanceof Libro) {
            Libro libro = (Libro) m;
            System.out.println("Es un Libro. diasPrestamo: " + libro.diasPrestamo());
        }

        System.out.println("\n--- Interfaces y metodos default ---");
        Prestable[] items = {
            new Libro("Java Basico"),
            new Revista("Byte"),
            new EBook("POO Moderna")
        };

        System.out.println("Multa de cada elemento (3 dias):");
        for (Prestable p : items) {
            System.out.println("  " + p.multa(3));
        }
        System.out.println("Total de multas: " + bib.multaTotal(items, 3));
    }
}