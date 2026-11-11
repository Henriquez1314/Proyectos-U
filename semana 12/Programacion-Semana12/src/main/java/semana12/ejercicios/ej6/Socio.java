package semana12.ejercicios.ej6;

public class Socio extends Miembro implements Reservable, Calificable {
    private double nota;

    public Socio(String nombre, double nota) {
        super(nombre);
        this.nota = nota;
    }

    @Override
    public void entrenar() {
        System.out.println("El socio " + nombre + " está entrenando en el gimnasio.");
    }

    @Override
    public int diasReservaMaximo() {
        return 30;
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