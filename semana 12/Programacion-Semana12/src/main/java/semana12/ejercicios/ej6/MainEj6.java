package semana12.ejercicios.ej6;

public class MainEj6 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 6: DISEÑO DEL GIMNASIO ===");

        Socio socio = new Socio("Ana", 8.5);
        Entrenador entrenador = new Entrenador("Carlos", 9.0);
        Maquina maquina = new Maquina("Caminadora");
        ClaseGrupal clase = new ClaseGrupal("Zumba", 7.5);

        System.out.println("\n--- Entrenamiento ---");
        socio.entrenar();
        entrenador.entrenar();
        clase.entrenar();

        System.out.println("\n--- Reservas ---");
        Reservable[] reservables = { socio, maquina, clase };
        for (Reservable r : reservables) {
            System.out.println("Max dias de reserva: " + r.diasReservaMaximo() +
                               " | Disponible: " + r.estaDisponible());
        }

        System.out.println("\n--- Calificaciones ---");
        Calificable[] calificables = { socio, entrenador, clase };
        for (Calificable c : calificables) {
            System.out.println("Puntos: " + c.puntos());
        }
    }
}