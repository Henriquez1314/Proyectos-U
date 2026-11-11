package semana12.biblioteca;

public interface Prestable {
    int MULTA_DIARIA = 1;

    void prestar(String socio);

    default int multa(int diasRetraso) {
        return diasRetraso * MULTA_DIARIA;
    }
}
