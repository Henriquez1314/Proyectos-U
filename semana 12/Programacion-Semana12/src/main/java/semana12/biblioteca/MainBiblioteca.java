package semana12.biblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Material[] materiales = {
            new Libro("Java Basico"),
            new Revista("Byte"),
            new EBook("POO Moderna"),
            new Mapa("El Salvador")
        };

        System.out.println("--- Catalogo ---");
        for (Material m : materiales) {
            System.out.println(m.describir() + " | " + m.diasPrestamo() + " dias");
        }

        System.out.println("--- Prestamos ---");
        for (Material m : materiales) {
            if (m instanceof Prestable p) {
                p.prestar("Ana");
            } else {
                System.out.println(m.getTitulo() + ": solo en sala");
            }
        }

        System.out.println("--- Ligadura ---");
        Material mAlgoritmos = new Libro("Algoritmos");
        System.out.println(mAlgoritmos.describir());
        biblioteca.registrar(mAlgoritmos);
        Libro lAlgoritmos = (Libro) mAlgoritmos;
        biblioteca.registrar(lAlgoritmos);
        System.out.println(Material.tipo() + " / " + Libro.tipo());

        System.out.println("--- Multas (3 dias) ---");
        Prestable[] prestables = {
            (Prestable) materiales[0],
            (Prestable) materiales[1],
            (Prestable) materiales[2]
        };

        for (Prestable p : prestables) {
            System.out.println(p.multa(3));
        }

        int total = biblioteca.multaTotal(prestables, 3);
        System.out.println("Total: $" + total);
    }
}
