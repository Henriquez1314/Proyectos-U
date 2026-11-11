package semana12.ejercicios.ej2;

public class  MainEj2 {
    public static void main(String[] args) {
        System.out.println(" EJERCICIO 2: SOBRECARGA CON TIPOS PRIMITIVO ");
        Ej2 ej2 = new Ej2();

        ej2.ver(5);
        ej2.ver(5.5);
        ej2.ver((short) 5);
        ej2.ver("Hola");
        ej2.ver(5.5f);
    }
}
