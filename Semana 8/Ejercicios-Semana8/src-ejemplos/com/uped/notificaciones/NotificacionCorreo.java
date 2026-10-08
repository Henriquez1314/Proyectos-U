package com.uped.notificaciones;

public class NotificacionCorreo extends Notificacion {

    private String asunto;

    public NotificacionCorreo(String destinatario, String mensaje, String asunto) {
        super(destinatario, mensaje);
        this.asunto = asunto;
    }

    @Override
    public void enviar() {
        System.out.println("[Correo] Enviando a " + destinatario
                + " | Asunto: " + asunto
                + " | Mensaje: " + mensaje);
    }

    public String getAsunto() {
        return asunto;
    }
}
