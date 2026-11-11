package semana12.ejercicios.ej1;

public class MainEj1 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: LIGADURA (PLANTAS) ===");
        Planta p = new Cactus();

        System.out.print("Metodo regar(): ");
        p.regar();

        System.out.println("Atributo tipo (declarado Planta): " + p.tipo);
        System.out.println("Metodo estatico clima() (declarado Planta): " + Planta.clima());

        System.out.println("Atributo tipo (casting a Cactus): " + ((Cactus) p).tipo);
        System.out.println("Metodo estatico clima() (Cactus): " + Cactus.clima());
    }
}
