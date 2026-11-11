package semana12.ejercicios.ej7;

import semana12.biblioteca.Material;
import semana12.biblioteca.Prestable;

public class MainEj7 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 7: AUDIOLIBRO (EXTENSION) ===");

        Audiolibro audio = new Audiolibro("Cien años de soledad");

        System.out.println("\n--- Describir (heredada de Material) ---");
        System.out.println(audio.describir());

        System.out.println("\n--- Préstamo (sobrescrito en Audiolibro) ---");
        audio.prestar("Ana");

        System.out.println("\n--- Multa (heredada de Prestable) ---");
        System.out.println("Multa por 5 días de retraso: " + audio.multa(5));

        System.out.println("\n--- Dias de prestamo (sobrescrito) ---");
        System.out.println("Días de préstamo: " + audio.diasPrestamo());

        System.out.println("\n--- Verificación de tipos ---");
        System.out.println("Es Material: " + (audio instanceof Material));
        System.out.println("Es Prestable: " + (audio instanceof Prestable));
    }
}