package semana12.biblioteca;

public class EBook extends semana12.biblioteca.Material implements semana12.biblioteca.Prestable, semana12.biblioteca.Digital {

    public EBook(String titulo) {
        super(titulo);
    }

    @Override
    public int diasPrestamo() {
        return 21;
    }

    @Override
    public String formato() {
        return "PDF";
    }

    @Override
    public String describir() {
        return "EBook: " + titulo + " [" + formato() + "]";
    }

    @Override
    public void prestar(String socio) {
        System.out.println(titulo + " -> " + socio + " (descarga)");
    }

    @Override
    public int multa(int diasRetraso) {
        return 0;
    }
}
