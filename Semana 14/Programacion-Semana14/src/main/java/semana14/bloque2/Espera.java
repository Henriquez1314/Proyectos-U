package semana14.bloque2;

public class Espera {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
            throw new InterruptedException("La espera fue interrumpida");
        } catch (InterruptedException e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println("Continuación del programa");
    }
}