package semana10;

public class MainNotificaciones {

    public static void main(String[] args) {

        GestorNotificaciones gestor = new GestorNotificaciones();

        Notificacion correo = new NotificacionEmail(
                "ana@uped.edu.sv", "Tarea calificada");

        Notificacion sms = new NotificacionSMS(
                "70011223", "Su pago fue confirmado hoy");

        Notificacion push = new NotificacionPush(
                "dispositivo-102", "Nuevo mensaje", 3);

        gestor.notificar(correo);
        gestor.notificar(sms, 2);
        gestor.notificar(push, true);
        gestor.notificar("72244455", "Recordatorio de clase");

        System.out.println("--- Reto: envio repetido ---");

        Notificacion pushReto = new NotificacionPush(
                "dispositivo-9", "Recordatorio", 4);

        pushReto.enviar(2);
    }
}