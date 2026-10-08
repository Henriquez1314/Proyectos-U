package com.uped.notificaciones;

public abstract class Notificacion {

    protected String destinatario;
    protected String mensaje;
    private String historial;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.historial = "Sin envios registrados";
    }

    // Metodo abstracto: cada canal envia el mensaje de forma distinta
    public abstract void enviar();

    // Metodo concreto y final: todas las notificaciones registran
    // el historial de la misma manera y ese comportamiento no cambia
    public final void registrarEnvio() {
        historial = "Enviado a " + destinatario;
        System.out.println("[Historial] " + historial);
    }

    public final String getHistorial() {
        return historial;
    }
}
