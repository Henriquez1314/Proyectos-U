package semana12.ejercicios.ej4;

public class Tarea implements Calificable {
    private double nota;

    public Tarea(double nota) {
        this.nota = nota;
    }

    @Override
    public double puntos() {
        return nota;
    }
}