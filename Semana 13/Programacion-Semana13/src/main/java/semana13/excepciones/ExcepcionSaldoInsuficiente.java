package semana13.excepciones;

public class ExcepcionSaldoInsuficiente extends Exception {
    private double saldoActual;
    private double montoRequerido;

    public ExcepcionSaldoInsuficiente(double saldoActual, double montoRequerido) {
        super("Transacción fallida: Saldo insuficiente.");
        this.saldoActual = saldoActual;
        this.montoRequerido = montoRequerido;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getMontoRequerido() {
        return montoRequerido;
    }

    public double getFaltante() {
        return montoRequerido - saldoActual;
    }

    @Override
    public String toString() {
        return "ExcepcionSaldoInsuficiente: Saldo actual $" + saldoActual + 
               ", monto requerido $" + montoRequerido + 
               ". Faltan $" + getFaltante();
    }
}
