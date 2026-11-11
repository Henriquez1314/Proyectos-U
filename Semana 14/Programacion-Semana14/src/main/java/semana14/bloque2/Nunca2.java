package semana14.bloque2;

public class Nunca2 {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO: Excepción unchecked que SÍ compila ===");
        try {
            int divisor = 0;
            int resultado = 10 / divisor;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("¡ArithmeticException capturada!");
            System.out.println("Detalle: " + e.getMessage() + " (división por cero)");
        } catch (Exception e) {
            System.out.println("Otra excepción: " + e.getClass().getName());
        }
        System.out.println("Programa continúa sin exigir manejo explícito previo.");
    }
}