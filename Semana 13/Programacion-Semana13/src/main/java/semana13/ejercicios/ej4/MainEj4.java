package semana13.ejercicios.ej4;

public class MainEj4 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4: Excepción Personalizada ===");
        try {
            validarEdad(15);
        } catch (ExcepcionEdadInvalida e) {
            System.err.println("Error de validación: " + e.getMessage());
        }
    }

    public static void validarEdad(int edad) throws ExcepcionEdadInvalida {
        if (edad < 18) {
            throw new ExcepcionEdadInvalida("La edad ingresada (" + edad + ") no es permitida para este trámite.");
        }
        System.out.println("Edad validada correctamente.");
    }
}
