package semana14.bloque3;

public class Orden2 {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO: Orden de catch ===");
        try {
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Catch de ArithmeticException activado.");
            System.out.println("Detalle: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Catch de RuntimeException activado.");
        } catch (Exception e) {
            System.out.println("Catch de Exception general.");
        }
        System.out.println("Fin del programa - orden correcto.");
    }
}