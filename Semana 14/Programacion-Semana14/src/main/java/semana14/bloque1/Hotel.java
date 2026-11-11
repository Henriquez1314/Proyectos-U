package semana14.bloque1;

public class Hotel {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE CATCH POLIMÓRFICO ===");

        probarReserva(1);
        probarReserva(2);
        probarReserva(3);
        probarReserva(4);
    }

    public static void probarReserva(int direccion) {
        System.out.println("\n--- Evaluando dirección de reserva: " + direccion + " ---");
        try {
            if (direccion == 1) {
                int division = 10 / 0;
            } else if (direccion == 2) {
                String texto = null;
                int longitud = texto.length();
            } else if (direccion == 3) {
                int[] registro = new int[2];
                int valor = registro[5];
            } else {
                System.out.println("Reserva procesada correctamente sin excepciones.");
            }
        } catch (RuntimeException e) {
            System.out.println("¡Catch polimórfico activado!");
            System.out.println("Clase capturada (polimorfismo): RuntimeException");
            System.out.println("Tipo real de la excepción (getClass().getSimpleName()): " + e.getClass().getSimpleName());
            System.out.println("mensaje de la excepción: " + e.getMessage());
        }
    }
}