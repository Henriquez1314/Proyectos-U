package semana13.excepciones;

public class ExcepcionStockInsuficiente extends Exception {
    private String nombreProducto;
    private int stockDisponible;
    private int stockSolicitado;

    public ExcepcionStockInsuficiente(String nombreProducto, int stockDisponible, int stockSolicitado) {
        super("Error de inventario: Stock insuficiente para " + nombreProducto);
        this.nombreProducto = nombreProducto;
        this.stockDisponible = stockDisponible;
        this.stockSolicitado = stockSolicitado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public int getStockSolicitado() {
        return stockSolicitado;
    }

    @Override
    public String toString() {
        return "ExcepcionStockInsuficiente: Solo hay " + stockDisponible + 
               " unidades de '" + nombreProducto + "' (Solicitadas: " + stockSolicitado + ")";
    }
}
