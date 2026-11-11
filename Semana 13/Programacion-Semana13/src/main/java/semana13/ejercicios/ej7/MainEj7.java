package semana13.ejercicios.ej7;

public class MainEj7 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 7: try-with-resources ===");

        try (RecursoSimulado rs = new RecursoSimulado()) {
            rs.usar();
            System.out.println("-> Ejecutando lógica dentro del try...");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        System.out.println("-> Programa finalizado.");
    }
}
