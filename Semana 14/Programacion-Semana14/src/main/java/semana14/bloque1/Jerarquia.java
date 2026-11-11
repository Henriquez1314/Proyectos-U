package semana14.bloque1;

public class Jerarquia {
    public static void main(String[] args) {
        System.out.println("=== JERARQUÍA DE EXCEPCIONES EN JAVA ===");

        mostrarJerarquia(new NullPointerException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new ArithmeticException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new IndexOutOfBoundsException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new IllegalArgumentException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new ClassCastException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new NumberFormatException());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new OutOfMemoryError());
        System.out.println("----------------------------------------");
        mostrarJerarquia(new StackOverflowError());
    }

    public static void mostrarJerarquia(Throwable e) {
        Class<?> claseActual = e.getClass();
        System.out.println("Excepción evaluada: " + claseActual.getName());
        System.out.print("Cadena de herencia: ");

        StringBuilder sb = new StringBuilder();
        while (claseActual != null) {
            sb.insert(0, claseActual.getSimpleName());
            claseActual = claseActual.getSuperclass();
            if (claseActual != null) {
                sb.insert(0, " -> ");
            }
        }
        System.out.println(sb.toString());

        if (e instanceof Error) {
            System.out.println("Categoría: Error (Problema grave del sistema/JVM, no manejable habitualmente).");
        } else if (e instanceof RuntimeException) {
            System.out.println("Categoría: Excepción No Verificada (Unchecked / RuntimeException).");
        } else if (e instanceof Exception) {
            System.out.println("Categoría: Excepción Verificada (Checked Exception).");
        }
    }
}