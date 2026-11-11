package semana13.tienda;

import semana13.excepciones.ExcepcionSaldoInsuficiente;
import semana13.excepciones.ExcepcionStockInsuficiente;
import semana13.excepciones.ExcepcionProductoNoEncontrado;

public class MainTienda {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" CASO INTEGRADOR: CAJA DE TIENDA EN LÍNEA ");
        System.out.println("==================================================\n");

        TiendaOnline tienda = new TiendaOnline("TechStore Global");
        tienda.registrarProducto(new Producto("P001", "Laptop Gamer", 1200.0, 5));
        tienda.registrarProducto(new Producto("P002", "Mouse Inalámbrico", 25.5, 10));
        tienda.registrarProducto(new Producto("P003", "Teclado Mecánico", 85.0, 3));

        tienda.mostrarCatalogo();
        System.out.println();

        Cuenta cuentaCliente = new Cuenta("Carlos Pérez", 1500.0);
        Carrito carrito = new Carrito();

        System.out.println("--- PRUEBA 1: Compra Exitosa ---");
        try {
            Producto p1 = tienda.buscarProducto("P002"); // Mouse
            carrito.agregarProducto(p1, 2);

            Producto p2 = tienda.buscarProducto("P003"); // Teclado
            carrito.agregarProducto(p2, 1);

            Compra.procesarPago(cuentaCliente, carrito);
        } catch (ExcepcionSaldoInsuficiente | ExcepcionStockInsuficiente e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA 2: Excepción por Stock Insuficiente ---");
        Carrito carrito2 = new Carrito();
        try {
            Producto laptop = tienda.buscarProducto("P001");
            carrito2.agregarProducto(laptop, 10); // Solo hay 5 en stock
        } catch (ExcepcionStockInsuficiente e) {
            System.out.println("-> " + e);
        }

        System.out.println("\n--- PRUEBA 3: Excepción por Producto No Encontrado (RuntimeException) ---");
        try {
            tienda.buscarProducto("P999");
        } catch (ExcepcionProductoNoEncontrado e) {
            System.out.println("-> Capturado RuntimeException: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA 4: Excepción por Saldo Insuficiente ---");
        Carrito carrito3 = new Carrito();
        try {
            Producto laptop = tienda.buscarProducto("P001"); // $1200
            carrito3.agregarProducto(laptop, 1);

            Cuenta cuentaPobre = new Cuenta("Ana Gómez", 50.0);
            Compra.procesarPago(cuentaPobre, carrito3);
        } catch (ExcepcionSaldoInsuficiente e) {
            System.out.println("-> " + e);
            System.out.println("-> Consejo: Le faltan $" + e.getFaltante() + " para completar la compra.");
        } catch (ExcepcionStockInsuficiente e) {
            System.out.println("-> " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println(" FIN DEL CASO INTEGRADOR ");
        System.out.println("==================================================");
    }
}
