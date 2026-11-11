package semana12.ejercicios.ej7;

import semana12.biblioteca.Material;
import semana12.biblioteca.Prestable;

public class Audiolibro extends Material implements Prestable {

    public Audiolibro(String titulo) {
        super(titulo);
    }

    @Override
    public int diasPrestamo() {
        return 10;
    }

    @Override
    public void prestar(String socio) {
        System.out.println(titulo + " -> " + socio + " (descarga de audio)");
    }
}