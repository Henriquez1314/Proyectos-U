package semana12.biblioteca;

public class Mapa extends Material {

    public Mapa(String titulo) {
        super(titulo);
    }

    @Override
    public int diasPrestamo() {
        return 0;
    }
}
