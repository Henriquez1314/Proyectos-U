package semana13.tienda;

import semana13.excepciones.ExcepcionProductoNoEncontrado;
import java.util.HashMap;
import java.util.Map;

public class TiendaOnline {
    private String nombre;
    private Map<String, Producto> catalogo;

    public TiendaOnline(String nombre) {
        this.nombre = nombre;
        this.catalogo = new HashMap<>();
    }

    public void registrarProducto(Producto p) {
        catalogo.put(p.getCodigo(), p);
    }

    public Producto buscarProducto(String codigo) {
        Producto p = catalogo.get(codigo);
        if (p == null) {
            throw new ExcepcionProductoNoEncontrado(codigo);
        }
        return p;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarCatalogo() {
        System.out.println("=== CATÁLOGO DE LA TIENDA: " + nombre + " ===");
        for (Producto p : catalogo.values()) {
            System.out.println("  " + p);
        }
    }
}
