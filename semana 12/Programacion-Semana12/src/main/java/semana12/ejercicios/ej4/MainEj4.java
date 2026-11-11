package semana12.ejercicios.ej4;


public class MainEj4 {
    public static void main(String[] args) {
        System.out.println("== EJERCICIO 4: DEFAULT HEREDADO O SOBRESCRITO ==");

        Tarea tarea = new Tarea(7.5);
        Proyecto proyecto = new Proyecto(8.0);
        Quiz quiz = new Quiz(6.0);

        System.out.println("Tarea (hereda default): " + tarea.puntos());
        System.out.println("Proyecto (sobrescribe puntos(): " + proyecto.puntos());
        System.out.println("Quiz (hereda default): " + quiz.puntos());

        System.out.println("\n--- Uso del metodo default heredado 'describir()' ---");
        System.out.println("Tarea: " + tarea.describir());
        System.out.println("Proyecto: " + proyecto.describir());
        System.out.println("Quiz: " + quiz.describir());
    }
}