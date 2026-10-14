package semana10;

public class GestorNotificaciones {

    public void notificar(Notificacion n) {
        System.out.println("--- Envio simple ---");
        n.enviar();
    }

    public void notificar(Notificacion n, int intentos) {
        System.out.println("--- Envio con reintentos ---");

        for (int i = 1; i <= intentos; i++) {
            System.out.println("Intento " + i + " de " + intentos);
        }

        n.enviar();
    }

    public void notificar(Notificacion n, boolean urgente) {
        System.out.println("--- Envio urgente: " + urgente + " ---");
        n.enviar();
    }

    public void notificar(String destinatario, String mensaje) {
        System.out.println("--- Envio rapido ---");
        System.out.println("Para: " + destinatario);
        System.out.println("Msj: " + mensaje);
    }
}