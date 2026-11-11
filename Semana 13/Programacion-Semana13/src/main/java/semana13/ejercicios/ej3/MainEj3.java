package semana13.ejercicios.ej3;

public class MainEj3 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: Bloque finally ===");
        try {
            System.out.println("Intentando operación...");
            if (true) throw new RuntimeException("Error inesperado");
        } catch (RuntimeException e) {
            System.err.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println(">>> Este bloque finally SIEMPRE se ejecuta, incluso tras el error.");
        }
    }
}
