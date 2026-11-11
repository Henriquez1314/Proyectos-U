package semana13.tienda;

import semana13.excepciones.ExcepcionSaldoInsuficiente;

public class Cuenta {
    private String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
        }
        saldo += monto;
        System.out.println("-> Depósito exitoso de $" + monto + ". Saldo actual: $" + saldo);
    }

    public void retirar(double monto) throws ExcepcionSaldoInsuficiente {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
        }
        if (monto > saldo) {
            throw new ExcepcionSaldoInsuficiente(saldo, monto);
        }
        saldo -= monto;
        System.out.println("-> Retiro exitoso de $" + monto + ". Saldo restante: $" + saldo);
    }
}
