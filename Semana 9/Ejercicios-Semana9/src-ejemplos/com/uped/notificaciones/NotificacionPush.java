package com.uped.notificaciones;

public class NotificacionPush extends Notificacion {

    private String tokenDispositivo;

    public NotificacionPush(String destinatario, String mensaje, String tokenDispositivo) {
        super(destinatario, mensaje);
        this.tokenDispositivo = tokenDispositivo;
    }

    @Override
    public void enviar() {
        System.out.println("[Push] Enviando al dispositivo token " + tokenDispositivo
                + " de " + destinatario
                + " | Mensaje: " + mensaje);
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }
}
