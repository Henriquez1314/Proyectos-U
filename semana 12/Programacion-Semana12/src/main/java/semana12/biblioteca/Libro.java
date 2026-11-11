package semana12.biblioteca;

public class Libro extends Material implements Prestable {

    public Libro(String titulo) {
        super(titulo);
    }

    @Override
    public int diasPrestamo() {
        return 14;
    }

    @Override
    public String describir() {
        return "Libro: " + titulo;
    }

    @Override
    public void prestar(String socio) {
        System.out.println(titulo + " -> " + socio + " (" + diasPrestamo() + " dias)");
    }

    public static String tipo() {
        return "LIBRO";
    }
}
