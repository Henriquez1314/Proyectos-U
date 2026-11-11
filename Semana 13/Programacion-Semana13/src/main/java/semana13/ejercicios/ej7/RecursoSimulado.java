package semana13.ejercicios.ej7;

public class RecursoSimulado implements AutoCloseable {
    
    public void usar() {
        System.out.println("-> Usando el recurso simulado...");
    }

    @Override
    public void close() {
        System.out.println("-> [AUTO] El recurso ha sido cerrado automáticamente.");
    }
}
