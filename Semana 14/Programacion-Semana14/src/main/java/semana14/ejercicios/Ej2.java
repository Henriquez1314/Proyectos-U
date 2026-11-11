package semana14.ejercicios;

public class Ej2 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Clasificación de excepciones ===");

        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Tipo A: " + e.getClass().getSimpleName());
        }

        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Tipo B: " + e.getClass().getSimpleName());
        }

        try {
            int[] registro = new int[2];
            int valor = registro[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tipo C: " + e.getClass().getSimpleName());
        }

        System.out.println("Fin del Ejercicio 2.");
    }
}