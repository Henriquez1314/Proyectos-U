package com.uped.proyecto;

import com.uped.proyecto.modelo.*;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                "Ana López",
                "04512378-9",
                "7777-1234",
                4000.0
        );

        Empleado empleado = new Empleado(
                "Luis Pérez",
                "06223456-1",
                850.0
        );

        Estudiante estudiante = new Estudiante(
                "Carlos Ramírez",
                "06123456-7",
                "UPED-2026-045",
                "Ing. en Sistemas",
                9.1
        );

        Docente docente = new Docente(
                "María Hernández",
                "05987654-3",
                "Ingeniería de Software",
                8
        );

        Voluntario voluntario = new Voluntario(
                "Sara Gómez",
                "07456123-2",
                120.0
        );

        Persona[] personas = {
                cliente,
                empleado,
                estudiante,
                docente,
                voluntario
        };

        for (Persona persona : personas) {
            System.out.println(
                    persona.presentarse()
                            + " -> $"
                            + persona.calcularBeneficioAnual()
            );
        }

        Proveedor prov = new Proveedor(
                "Comercial Ríos",
                "06554321-8",
                8000.0
        );

        System.out.println(prov);
        System.out.println("Beneficio: " + prov.calcularBeneficioAnual());

        System.out.println(voluntario);
        System.out.println(
                "Beneficio: "
                        + voluntario.calcularBeneficioAnual()
        );
    }
}