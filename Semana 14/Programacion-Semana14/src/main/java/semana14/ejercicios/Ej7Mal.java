package semana14.ejercicios;

public class Ej7Mal {
    public static void main(String[] args) {
        int counter = 0;
        try {
            int resultado = 10 / 0;
            String texto = null;
            int longitud = texto.length();
            Thread.sleep(1000);
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: " + e.getMessage());
            counter++;
        } catch (InterruptedException e) {
            System.out.println("Error de interrupción: " + e.getMessage());
            counter++;
        } catch (Exception e) {
            System.out.println("Otra excepción capturada.");
            counter++;
        }
        System.out.println("Total de errores capturados: " + counter);
    }
}