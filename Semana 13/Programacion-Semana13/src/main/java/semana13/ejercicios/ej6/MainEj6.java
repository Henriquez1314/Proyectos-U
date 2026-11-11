package semana13.ejercicios.ej6;

public class MainEj6 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 6: Re-throwing ===");
        try {
            nivelSuperior();
        } catch (Exception e) {
            System.err.println("Capturado finalmente en main: " + e.getMessage());
        }
    }

    public static void nivelSuperior() throws Exception {
        try {
            metodoConError();
        } catch (Exception e) {
            System.out.println("[LOG] Se detectó un error en nivelSuperior, registrando y re-lanzando...");
            throw e;
        }
    }

    public static void metodoConError() throws Exception {
        throw new Exception("Error original en la base del sistema.");
    }
}
