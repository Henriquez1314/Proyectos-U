package basemysql;

import com.uped.proyecto.modelo.*;

public class Main {
    static void main() {

        // Vehiculo
        Vehiculo v1 = Vehiculo.nuevo("P123-789", "Kia");

        System.out.println(v1);

        v1.recorrer(150);

        System.out.println(v1);

        v1.recorrer(-20);

        // ConfiguracionReporte - Builder
        ConfiguracionReporte reporte = new ConfiguracionReporte.Builder()
                .titulo("Reporte de ventas")
                .formato("PDF")
                .incluirGraficos(true)
                .incluirDetalles(true)
                .build();

        System.out.println(reporte);

        // Pedido - bloque de inicializacion
        Pedido pedido = new Pedido(101);

        // Suscripcion - cascada de constructores
        Suscripcion s1 = new Suscripcion("ana");
        System.out.println(s1);

        // Suscripcion - metodo de fabrica
        Suscripcion s2 = Suscripcion.premium("carlos");
        System.out.println(s2);

        new Registro();

        LibroBiblioteca l1 =
                new LibroBiblioteca("Clean Code", "R. Martin", 3);

        LibroBiblioteca l2 =
                LibroBiblioteca.unico("Effective Java", "J. Bloch");

        l1.prestar();
        l2.prestar();
        l2.prestar();

        new LibroBiblioteca("", "Autor X", 2);

    }
}