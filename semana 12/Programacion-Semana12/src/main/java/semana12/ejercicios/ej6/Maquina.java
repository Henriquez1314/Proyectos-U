package semana12.ejercicios.ej6;

public class Maquina implements Reservable {
    private String nombre;

    public Maquina(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int diasReservaMaximo() {
        return 7;
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }
}