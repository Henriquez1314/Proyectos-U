package semana14.integrador;

import java.util.Scanner;

public class Reservas {
    public static void main(String[] args) {
        System.out.println("=== CASO INTEGRADOR: COTIZADOR DE RESERVAS DE HOTEL ===");

        double[] tarifas = {50.0, 80.0, 120.0};

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Procesando Reserva " + i + " ---");
            try {
                System.out.print("Tipo de habitación (1=Simple, 2=Doble, 3=Suite): ");
                String entradaTipo = scanner.nextLine();
                int tipoHabitacion = Integer.parseInt(entradaTipo);

                System.out.print("Número de noches: ");
                String entradaNoches = scanner.nextLine();
                int noches = Integer.parseInt(entradaNoches);

                System.out.print("cantidad de personas: ");
                String entradaPersonas = scanner.nextLine();
                int personas = Integer.parseInt(entradaPersonas);

                if (noches <= 0) {
                    throw new ArithmeticException("Las noches deben ser mayores a 0");
                }
                if (personas <= 0) {
                    throw new ArithmeticException("La cantidad de personas debe ser mayor a 0");
                }

                double tarifaBase = tarifas[tipoHabitacion - 1];
                double precioTotal = tarifaBase * noches;
                double precioPorPersona = precioTotal / personas;

                System.out.println("Simulando espera de confirmación...");
                Thread.sleep(10);

                System.out.println("Reserva " + i + ": $" + precioPorPersona + " por persona");

            } catch (NumberFormatException e) {
                System.out.println("Reserva " + i + ": datos inconsistentes (NumberFormatException)");
            } catch (ArithmeticException | IndexOutOfBoundsException e) {
                System.out.println("Reserva " + i + ": datos inconsistentes (" + e.getClass().getSimpleName() + ")");
            } catch (InterruptedException e) {
                System.out.println("Reserva " + i + ": interrumpida - " + e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
            }
        }

        scanner.close();
        System.out.println("\n=== FIN DEL PROGRAMA: Todas las reservas procesadas ===");
    }
}