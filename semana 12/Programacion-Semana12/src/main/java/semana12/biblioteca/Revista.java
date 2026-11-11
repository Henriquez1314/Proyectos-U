package semana12.biblioteca;

public class Revista extends Material implements Prestable {

    public Revista(String titulo) {
        super(titulo);
    }

    @Override
    public int diasPrestamo() {
        return 7;
    }

    @Override
    public void prestar(String socio) {
        System.out.println(titulo + " -> " + socio + " (" + diasPrestamo() + " dias)");
    }

    @Override
    public int multa(int diasRetraso) {
        return diasRetraso * 2;
    }
}
