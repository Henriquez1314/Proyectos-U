package semana13.tienda;

import semana13.excepciones.ExcepcionStockInsuficiente;
import java.util.HashMap;
import java.util.Map;

public class Carrito {
    private Map<Producto, Integer> items;

    public Carrito() {
        this.items = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) throws ExcepcionStockInsuficiente {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser al menos 1.");
        }
        int stockActual = producto.getStock();
        int enCarrito = items.getOrDefault(producto, 0);
        int totalSolicitado = enCarrito + cantidad;

        if (totalSolicitado > stockActual) {
            throw new ExcepcionStockInsuficiente(producto.getNombre(), stockActual, totalSolicitado);
        }

        items.put(producto, totalSolicitado);
        System.out.println("-> Agregado al carrito: " + cantidad + " x " + producto.getNombre());
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Map.Entry<Producto, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

    public Map<Producto, Integer> getItems() {
        return items;
    }

    public void limpiar() {
        items.clear();
    }
}
