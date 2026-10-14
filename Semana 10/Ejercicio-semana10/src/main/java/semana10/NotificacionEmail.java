package semana10;

public class NotificacionEmail extends Notificacion {

    public NotificacionEmail(String destinatario, String mensaje) {
        super(destinatario, mensaje);
    }

    @Override
    public void enviar() {
        System.out.println("[EMAIL] Para: " + destinatario);
        System.out.println("[EMAIL] Asunto: Nueva notificacion");
        System.out.println("[EMAIL] Cuerpo: " + mensaje);
    }
}
