package semana14.bloque2;

public class Nunca {
    public static void main(String[] args) {
        try {
            int resultado = 10 + 5;
            String texto = "Hola";

            System.out.println("Operación realizada: " + resultado);
            System.out.println("Texto: " + texto);

        } finally {
            System.out.println("Bloque finally ejecutándose.");
        }

        System.out.println("Fin del programa Nunca.");
    }
}