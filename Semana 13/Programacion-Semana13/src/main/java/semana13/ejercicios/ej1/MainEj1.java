package semana13.ejercicios.ej1;

import java.util.Scanner;

public class MainEj1 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Manejo de Excepciones Básico ===");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese un número entero (dividendo): ");
            int a = scanner.nextInt();
            System.out.print("Ingrese otro número entero (divisor): ");
            int b = scanner.nextInt();

            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.err.println("Error: No se puede dividir por cero.");
        } catch (java.util.InputMismatchException e) {
            System.err.println("Error: Debe ingresar números enteros válidos.");
        } finally {
            scanner.close();
            System.out.println("Proceso finalizado.");
        }
    }
}
