package semana14.teoria;

public class CuadroComparativo {
    public static void main(String[] args) {
        System.out.println("=== CUADRO COMPARATIVO DE EXCEPCIONES DE JAVA ===\n");

        System.out.println("1. IOException");
        System.out.println("   Categoría: Excepción Checked (Verificada)");
        System.out.println("   Cadena de herencia: IOException -> Exception -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: Entrada/salida de archivo inexistente, error de lectura/escritura, permisos denegados.");
        System.out.println("   Cómo responder: Manejar con try-catch o declarar throws en la firma del método.");

        System.out.println("\n2. SQLException");
        System.out.println("   Categoría: Excepción Checked (Verificada)");
        System.out.println("   Cadena de herencia: SQLException -> IOException -> Exception -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: Errores en operaciones de base de datos (consulta inválida, conexión perdida, constraint violation).");
        System.out.println("   Cómo responder: Manejar con try-catch y usar bloques finally o try-with-resources para cerrar conexiones.");

        System.out.println("\n3. ArithmeticException");
        System.out.println("   Categoría: Excepción Unchecked (No Verificada / RuntimeException)");
        System.out.println("   Cadena de herencia: ArithmeticException -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: División entera o flotante por cero, operaciones matemáticas que exceden límites.");
        System.out.println("   Cómo responder: No es obligatorio capturarla con try-catch, pero se recomienda validar divisores antes de operar.");

        System.out.println("\n4. NullPointerException");
        System.out.println("   Categoría: Excepción Unchecked (No Verificada / RuntimeException)");
        System.out.println("   Cadena de herencia: NullPointerException -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: Intentar acceder a un método o atributo de un objeto null, acceder a longitud de null, etc.");
        System.out.println("   Cómo responder: Verificar referencias a null antes de usarlas, usar anotaciones @NotNull, validaciones defensivas.");

        System.out.println("\n5. ClassCastException");
        System.out.println("   Categoría: Excepción Unchecked (No Verificada / RuntimeException)");
        System.out.println("   Cadena de herencia: ClassCastException -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: Intentar convertir un objeto a un tipo de clase incompatible (casting inválido).");
        System.out.println("   Cómo responder: Usar instanceof o getClass() para verificar el tipo antes del casting; probar polimorfismo.");

        System.out.println("\n6. FileNotFoundException");
        System.out.println("   Categoría: Excepción Checked (Verificada)");
        System.out.println("   Cadena de herencia: FileNotFoundException -> IOException -> Exception -> RuntimeException -> Throwable");
        System.out.println("   Situación que la provoca: Intentar abrir un archivo que no existe o a cuyo acceso se ha denegado el permiso.");
        System.out.println("   Cómo responder: Manejar con try-catch o usar Files.exists() antes de intentar la operación.");

        System.out.println("\n=== FIN DEL CUADRO COMPARATIVO ===");
    }
}