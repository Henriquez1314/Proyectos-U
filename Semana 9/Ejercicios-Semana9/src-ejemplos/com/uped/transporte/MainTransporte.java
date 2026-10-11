package com.uped.transporte;

import com.uped.transporte.modelo.Automovil;
import com.uped.transporte.modelo.Motocicleta;
import com.uped.transporte.modelo.CamionDeCarga;
import com.uped.transporte.modelo.Vehiculo;

public class   MainTransporte {

    public static void main(String[] args) {

        Vehiculo v1 = new Automovil("P123-456", 320);
        Vehiculo v2 = new Motocicleta("M789-012", 150);
        Vehiculo v3 = new CamionDeCarga("C345-678", 500);

        v1.mostrarFicha();
        System.out.println("Peaje: $"
            + v1.calcularCostoPeaje());

        v2.mostrarFicha();
        System.out.println("Peaje: $"
            + v2.calcularCostoPeaje());

        v3.mostrarFicha();
        System.out.println("Peaje: $"
            + v3.calcularCostoPeaje());
    }
}
