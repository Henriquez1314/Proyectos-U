package semana12.ejercicios.ej6;

public abstract class Miembro {
    protected String nombre;

    public Miembro(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void entrenar();
}