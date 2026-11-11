package semana14.bloque3;

public class Multi {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE MULTI-CATCH ===");

        System.out.println("\n--- Caso 1: NumberFormatException ---");
        String numeroInvalido = "ABC123";
        try {
            int valor = Integer.parseInt(numeroInvalido);
            System.out.println("Parseo exitoso: " + valor);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Excepción capturada: " + e.getClass().getSimpleName());
            System.out.println("mensaje: " + e.getMessage());
        }

        System.out.println("\n--- Caso 2: NullPointerException ---");
        String texto = null;
        try {
            int longitud = texto.length();
            System.out.println("Longitud: " + longitud);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Excepción capturada: " + e.getClass().getSimpleName());
            System.out.println("mensaje: " + e.getMessage());
        }

        System.out.println("\n--- Caso 3: Éxito (ninguna excepción) ---");
        String textoValido = "12345";
        try {
            int valor = Integer.parseInt(textoValido);
            System.out.println("Parseo exitoso: " + valor);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Excepción capturada: " + e.getClass().getSimpleName());
            System.out.println("mensaje: " + e.getMessage());
        }

        System.out.println("\n--- Caso 4: Otro NumberFormatException ---");
        String otroInvalido = null;
        try {
            int valor = Integer.parseInt(otroInvalido);
            System.out.println("Parseo exitoso: " + valor);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Excepción capturada: " + e.getClass().getSimpleName());
            System.out.println("mensaje: " + e.getMessage());
        }
    }
}