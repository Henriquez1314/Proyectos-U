package semana14.ejercicios;

public class Ej6 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 6: Cuatro resultados de manejo de excepciones ===");

        int counter = 0;

        try {
            int division = 20 / 0;
            System.out.println("Resultado 1: No debería verse este mensaje (ArithmeticException capturado).");
        } catch (ArithmeticException e) {
            System.out.println("Resultado 1 - ArithmeticException capturado: división por cero.");
            counter++;
        }

        try {
            String texto = "ABC";
            int valor = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Resultado 2 - NumberFormatException capturado: formato de número inválido.");
            counter++;
        }

        try {
            int[] numeros = new int[3];
            int valor = numeros[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Resultado 3 - ArrayIndexOutOfBoundsException capturado: índice fuera de límites.");
            counter++;
        }

        try {
            int resultado = 10 + 5;
            System.out.println("Resultado 4 - No hubo excepciones: operación aritmética exitosa (resultado = " + resultado + ").");
            counter++;
        } catch (Exception e) {
            System.out.println("Resultado 4 - Excepción general capturada: " + e.getClass().getSimpleName());
            counter++;
        }

        System.out.println("\nTotal de resultados procesados: " + counter);
        System.out.println("Fin del Ejercicio 6.");
    }
}