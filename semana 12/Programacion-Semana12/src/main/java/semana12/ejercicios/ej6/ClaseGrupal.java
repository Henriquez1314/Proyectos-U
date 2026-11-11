package semana12.ejercicios.ej6;

public class ClaseGrupal extends Miembro implements Reservable, Calificable {
    private double nota;

    public ClaseGrupal(String nombre, double nota) {
        super(nombre);
        this.nota = nota;
    }

    @Override
    public void entrenar() {
        System.out.println("Clase grupal '" + nombre + "' en curso.");
    }

    @Override
    public int diasReservaMaximo() {
        return 14;
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }

    @Override
    public double puntos() {
        return nota;
    }
}