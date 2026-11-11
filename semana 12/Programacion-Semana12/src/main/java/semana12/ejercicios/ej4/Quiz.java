package semana12.ejercicios.ej4;

public class Quiz implements Calificable {
    private double nota;

    public Quiz(double nota) {
        this.nota = nota;
    }

    @Override
    public double puntos() {
        return nota;
    }
}