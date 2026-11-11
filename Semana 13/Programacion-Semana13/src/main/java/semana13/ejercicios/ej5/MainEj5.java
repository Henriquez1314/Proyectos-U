package semana13.ejercicios.ej5;

public class MainEj5 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 5: Multi-catch ===");
        
        try {
            String str = null;
            int error2 = str.length(); 
            
        } catch (ArithmeticException | NullPointerException e) {
            System.err.println("Se capturó un error común mediante Multi-catch: " + e.getClass().getSimpleName());
            System.err.println("Mensaje: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Se capturó una excepción genérica: " + e.getMessage());
        }
    }
}
