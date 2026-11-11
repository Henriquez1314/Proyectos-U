package semana12.biblioteca;

public class Audiolibro extends semana12.biblioteca.Material implements semana12.biblioteca.Prestable {

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