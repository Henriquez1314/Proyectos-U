package semana12.ejercicios.ej4;

public class Proyecto implements Calificable {
    private double nota;

    public Proyecto(double nota) {
        this.nota = nota;
    }

    @Override
    public double puntos() {
        return nota + 10;
    }
}