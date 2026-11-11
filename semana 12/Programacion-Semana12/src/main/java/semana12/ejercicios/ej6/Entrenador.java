package semana12.ejercicios.ej6;

public class Entrenador extends Miembro implements Calificable {
    private double nota;

    public Entrenador(String nombre, double nota) {
        super(nombre);
        this.nota = nota;
    }

    @Override
    public void entrenar() {
        System.out.println("El entrenador " + nombre + " está instructiendo la clase.");
    }

    @Override
    public double puntos() {
        return nota;
    }
}