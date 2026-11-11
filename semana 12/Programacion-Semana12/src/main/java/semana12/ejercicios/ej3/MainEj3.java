package semana12.ejercicios.ej3;

import semana12.biblioteca.*;

public class MainEj3 {
    public static void main(String[] args) {
        System.out.println(" EJERCICIO 3: ERRORES DE COMPILACION Y REGLAS ");

        System.out.println("Error 1: 'new Material()' falla en tiempo de compilacion.");
        System.out.println("Explicacion: Material es abstracta, solo se pueden instanciar subclases concretas como Libro o Revista.\n");

        System.out.println("Error 2: Acceso incorrecto a metodos estaticos mediante instancias polimorficas.");
        System.out.println("Explicacion: Los metodos estaticos se enlazan de forma estatica (Material.tipo()). No se heredan ni se pueden sobrescribir dinamicamente.\n");

        System.out.println("Error 3: Falta de casteo explicito al acceder a metodos de subtipos.");
        System.out.println("Explicacion: Si una variable es de tipo Material y el objeto es un Libro, se debe usar 'instanceof' y casteo para usar metodos de Libro.\n");

        System.out.println("Error 4: Intentar extender una clase final o implementar metodos abstractos sin sobrescribirlos.");
        System.out.println("Explicacion: Si una clase hereda de Material, debe obligatoriamente implementar diasPrestamo().\n");

        System.out.println("--- Demostraciones de uso correcto ---");
        Material libro = new Libro("Java Basico");
        System.out.println("Creamos un Libro de forma correcta: " + libro.describir());
        System.out.println("Llamada al metodo estatico Material.tipo(): " + Material.tipo());
        System.out.println("Verificamos el tipo real con instanceof y casteamos:");
        if (libro instanceof Libro lib) {
            System.out.println("  Es un Libro. Su metodo estatico es: " + Libro.tipo());
        }
    }
}