package semana14.ejercicios;

public class Ej7 {
    public static void main(String[] args) {
        int counter = 0;

        try {
            int resultado = 10 / 0;
            String texto = null;
            int longitud = texto.length();
            Thread.sleep(0);
        } catch (ArithmeticException e) {
            System.out.println("Error matemático (ArithmeticException): " + e.getMessage());
            counter++;
        } catch (NullPointerException e) {
            System.out.println("Error nulo (NullPointerException): " + e.getMessage());
            counter++;
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida (InterruptedException): " + e.getMessage());
            Thread.currentThread().interrupt();
            counter++;
        } catch (Exception e) {
            System.out.println("Otra excepción capturada (Exception general).");
            counter++;
        }

        System.out.println("Total de errores capturados: " + counter);
        System.out.println("Fin del Ejercicio 7 - versión corregida.");
    }
}