package com.uped.proyecto.modelo;

/**
 * Cliente de tipo preferente. Aplica la prueba "es un": un ClienteVIP
 * es un Cliente, por lo que puede almacenarse en un arreglo de Persona
 * o Cliente sin romper el contrato de la jerarquia.
 *
 * <p>Decisiones de diseno arquitectonico (modificador {@code final}):
 * <ul>
 *   <li>La <strong>clase es final</strong> para cerrar la jerarquia: ninguna
 *       subclase podria reinterpretar que significa ser VIP. Esto mantiene
 *       estable el invariante del sistema y documenta que el comportamiento
 *       esta completo.</li>
 *   <li>El metodo {@code calcularBeneficioAnual()} es <strong>final</strong>
 *       para impedir que una futura subclase altere la formula del beneficio
 *       y rompa los reportes que dependen de ese calculo.</li>
 * </ul>
 *
 * <p>No se redeclaran los atributos heredados ({@code telefono},
 * {@code comprasAnuales}): son {@code private} en {@link Cliente} y acceder a
 * ellos por herencia evita el shadowing y mantiene una sola fuente de verdad.
 */
public final class ClienteVIP extends Cliente {

    private int puntosAcumulados;

    public ClienteVIP(String nombre, String dui, String telefono,
                      double comprasAnuales, int puntosAcumulados) {
        super(nombre, dui, telefono, comprasAnuales);
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    @Override
    public final double calcularBeneficioAnual() {
        return super.calcularBeneficioAnual() + (puntosAcumulados * 2.0);
    }

    @Override
    public String toString() {
        return presentarse() + " | VIP, " + puntosAcumulados + " puntos";
    }
}