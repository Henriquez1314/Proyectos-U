package semana12.ejercicios.ej5;

public class Tablet {
    private String marca;
    private int anno;

    public Tablet(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    public void prender() {
        System.out.println("La tableta " + marca + " (" + anno + ") se está prendiendo.");
    }

    public static String tipo() {
        return "TABLET";
    }
}