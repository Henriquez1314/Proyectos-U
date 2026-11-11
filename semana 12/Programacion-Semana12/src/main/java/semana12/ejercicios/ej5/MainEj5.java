package semana12.ejercicios.ej5;

public class MainEj5 {
    public static void main(String[] args) {
        System.out.println("== EJERCICIO 5: ENCONTRAR LOS ERRORES ==");
        System.out.println("La clase Tablet.java contiene la explicación detallada de los 3 errores corregidos.\n");

        Tablet tablet = new Tablet("Samsung", 2024);
        tablet.prender();
        System.out.println("Tipo de tableta: " + Tablet.tipo());
    }
}