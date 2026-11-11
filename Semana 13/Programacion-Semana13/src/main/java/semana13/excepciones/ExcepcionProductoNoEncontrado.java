package semana13.excepciones;

public class ExcepcionProductoNoEncontrado extends RuntimeException {
    private String codigo;

    public ExcepcionProductoNoEncontrado(String codigo) {
        super("El producto con código '" + codigo + "' no existe en el catálogo.");
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
