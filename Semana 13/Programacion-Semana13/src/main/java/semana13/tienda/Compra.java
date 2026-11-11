package semana13.tienda;

import semana13.excepciones.ExcepcionSaldoInsuficiente;

public class Compra {

    public static void procesarPago(Cuenta cuenta, Carrito carrito) throws ExcepcionSaldoInsuficiente {
        double total = carrito.calcularTotal();
        System.out.println("\n[CAJA] Procesando pago total de: $" + total);

        try {
            cuenta.retirar(total);

            for (var entry : carrito.getItems().entrySet()) {
                entry.getKey().reducirStock(entry.getValue());
            }
            System.out.println("[CAJA] ¡Compra procesada y pagada con éxito!");
        } catch (ExcepcionSaldoInsuficiente e) {
            System.err.println("[CAJA ERROR] No se pudo completar el pago.");

            throw e;
        } finally {
            System.out.println("[CAJA LOG] Transacción finalizada en caja a las " + java.time.LocalTime.now());
        }
    }
}
