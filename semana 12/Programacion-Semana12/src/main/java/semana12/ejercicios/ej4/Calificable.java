package semana12.ejercicios.ej4;

public interface Calificable {

    double puntos();

    default String describir() {
        return "Elemento calificable";
    }
}