package com.uped.notificaciones;

public class MainNotificaciones {

    public static void main(String[] args) {

        System.out.println("=== 8.3 Sistema de notificaciones ===");
        System.out.println();

        NotificacionCorreo correo = new NotificacionCorreo(
                "ana@uped.edu.sv",
                "Su beca fue aprobada para el ciclo 02-2026",
                "Beca aprobada"
        );

        NotificacionSMS sms = new NotificacionSMS(
                "Carlos Ramirez",
                "Su cita es manana a las 9:00",
                "+503 7777-1234"
        );

        NotificacionPush push = new NotificacionPush(
                "Marta Diaz",
                "Tienes un mensaje nuevo en la aplicacion",
                "tok-app-0451"
        );

        Notificacion[] notificaciones = { correo, sms, push };

        for (Notificacion notificacion : notificaciones) {
            System.out.println("-- " + notificacion.getClass().getSimpleName() + " --");
            notificacion.registrarEnvio();
            notificacion.enviar();
            System.out.println("Historial: " + notificacion.getHistorial());
            System.out.println();
        }

        System.out.println("=== Metodos propios de cada subclase ===");
        System.out.println("Correo  -> asunto: " + correo.getAsunto());
        System.out.println("SMS     -> numero: " + sms.getNumeroTelefono());
        System.out.println("Push    -> token:  " + push.getTokenDispositivo());
        System.out.println();

        if (correo.getHistorial().startsWith("Enviado")
                && sms.getHistorial().startsWith("Enviado")
                && push.getHistorial().startsWith("Enviado")) {
            System.out.println("Correcto: las tres notificaciones registraron su envio con el metodo heredado");
        } else {
            System.out.println("Error: alguna notificacion no registro su envio");
        }
    }
}
