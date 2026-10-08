package com.uped.notificaciones;

public class NotificacionSMS extends Notificacion {

    private String numeroTelefono;

    public NotificacionSMS(String destinatario, String mensaje, String numeroTelefono) {
        super(destinatario, mensaje);
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public void enviar() {
        System.out.println("[SMS] Enviando al numero " + numeroTelefono
                + " de " + destinatario
                + " | Mensaje: " + mensaje);
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
}
