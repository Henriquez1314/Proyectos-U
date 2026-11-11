package semana12.biblioteca;

public class Biblioteca {

    public void registrar(semana12.biblioteca.Material m) {
        System.out.println("registro general: " + m.getTitulo());
    }

    public void registrar(semana12.biblioteca.Libro l) {
        System.out.println("registro de libro: " + l.getTitulo());
    }

    public int multaTotal(semana12.biblioteca.Prestable[] items, int dias) {
        int total = 0;
        for (semana12.biblioteca.Prestable item : items) {
            total += item.multa(dias);
        }
        return total;
    }
}
