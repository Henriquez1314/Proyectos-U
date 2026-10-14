package semana10;

public class NotificacionPush extends Notificacion {

    private int prioridad;

    public NotificacionPush(String destinatario, String mensaje, int prioridad) {
        super(destinatario, mensaje);
        this.prioridad = prioridad;
    }

    @Override
    public void enviar() {
        String nivel = prioridad >= 3 ? "ALTA" : "NORMAL";

        System.out.println("[PUSH] Dispositivo: " + destinatario);
        System.out.println("[PUSH] Prioridad: " + nivel);
        System.out.println("[PUSH] " + mensaje);
    }
}
