package semana10;

public class NotificacionSMS extends Notificacion {

    public NotificacionSMS(String destinatario, String mensaje) {
        super(destinatario, mensaje);
    }

    @Override
    public void enviar() {
        String texto = mensaje.length() > 20
                ? mensaje.substring(0, 20) + "..."
                : mensaje;

        System.out.println("[SMS] +503 " + destinatario + ": " + texto);
    }
}
