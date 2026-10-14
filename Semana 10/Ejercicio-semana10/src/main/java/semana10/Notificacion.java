package semana10;

public abstract class Notificacion {

    protected String destinatario;
    protected String mensaje;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
    }

    public abstract void enviar();

    public void enviar(int veces) {
        for (int i = 0; i < veces; i++) {
            enviar();
        }
    }

    public String getDestinatario() {
        return destinatario;
    }
}
