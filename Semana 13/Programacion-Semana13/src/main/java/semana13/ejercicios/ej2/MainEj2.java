package semana13.ejercicios.ej2;

public class MainEj2 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Propagación de Excepciones ===");
        try {
            procesarDato(10);
            procesarDato(-5);
        } catch (IllegalArgumentException e) {
            System.err.println("Capturado en main: " + e.getMessage());
        }
    }

    public static void procesarDato(int valor) throws IllegalArgumentException {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo: " + valor);
        }
        System.out.println("Procesando: " + valor);
    }
}
