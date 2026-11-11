package semana14.bloque2;

public class Espera2 {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO: Atendiendo excepción checked (InterruptedException) ===");
        try {
            System.out.println("Iniciando espera de 1 segundo...");
            Thread.sleep(500);
            System.out.println("Espera completada sin interrupciones.");
        } catch (InterruptedException e) {

            System.out.println("La espera fue interrumpida: " + e.getMessage());

            Thread.currentThread().interrupt();
        } catch (Exception e) {

            System.out.println("Otra excepción ocurrida: " + e.getClass().getName());
        }

        System.out.println("Programa continúa después del bloque try-catch.");
    }
}