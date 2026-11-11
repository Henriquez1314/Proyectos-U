package semana12.ejercicios.ej1;

public class Cactus extends Planta {
    public String tipo = "Cactus del desierto";

    public static String clima() {
        return "Clima arido";
    }

    @Override
    public void regar() {
        System.out.println("Regando cactus con muy poca agua.");
    }
}
