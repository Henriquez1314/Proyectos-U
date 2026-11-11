package semana14.bloque1;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE STACKOVERFLOWERROR ===");
        try {
            metodoRecursivo(1);
        } catch (StackOverflowError e) {
            System.out.println("¡Error capturado con éxito!");
            System.out.println("Tipo de error: " + e.getClass().getName());
            System.out.println("mensaje explicativo: Desbordamiento de la pila de llamadas (StackOverflowError).");
            System.out.println("Causa: Llamadas recursivas infinitas o excesivamente profundas sin caso base válido.");
        } catch (Throwable t) {
            System.out.println("Capturado Throwable genérico: " + t);
        }
    }

    public static void metodoRecursivo(int counter) {
        if (counter % 1000 == 0) {
            System.out.println("Nivel de recursión: " + counter);
        }
        metodoRecursivo(counter + 1);
    }
}