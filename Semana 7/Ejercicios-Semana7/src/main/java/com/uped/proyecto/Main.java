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

        System.out.println();
        System.out.println("=== Semana 7: herencia multinivel ===");

        Gerente gerente = new Gerente(
                "Marta Díaz",
                "05123456-7",
                1200.0,
                5
        );

        System.out.println(gerente);
        System.out.println("Beneficio: " + gerente.calcularBeneficioAnual());

        if (gerente.calcularBeneficioAnual() == 245.0) {
            System.out.println("Correcto: beneficio del gerente = 245.0");
        } else {
            System.out.println("Error: el beneficio del gerente no es 245.0");
        }

        DocenteInvestigador docenteInvestigador = new DocenteInvestigador(
                "Dr. Iván Reyes",
                "07321456-9",
                "Ingeniería de Software",
                8,
                4
        );

        System.out.println(docenteInvestigador);
        System.out.println("Beneficio: " + docenteInvestigador.calcularBeneficioAnual());

        if (docenteInvestigador.calcularBeneficioAnual() == 480.0) {
            System.out.println("Correcto: beneficio del docente investigador = 480.0");
        } else {
            System.out.println("Error: el beneficio del docente investigador no es 480.0");
        }

        ClienteVIP clienteVip = new ClienteVIP(
                "Rosa Méndez",
                "04876543-2",
                "9911-2233",
                9000.0,
                150
        );

        System.out.println(clienteVip);
        System.out.println("Beneficio: " + clienteVip.calcularBeneficioAnual());

        Persona[] equipo = {
                gerente,
                docenteInvestigador,
                clienteVip,
                empleado
        };

        System.out.println();
        System.out.println("=== Recorrido polimorfico con instanceof ===");

        for (Persona persona : equipo) {
            System.out.println(persona.presentarse()
                    + " -> $"
                    + persona.calcularBeneficioAnual());

            if (persona instanceof Gerente) {
                Gerente gerenteActual = (Gerente) persona;
                System.out.println("  Es un Gerente con equipo de "
                        + gerenteActual.getTamanoEquipo()
                        + " personas");
            } else if (persona instanceof DocenteInvestigador) {
                DocenteInvestigador docenteActual = (DocenteInvestigador) persona;
                System.out.println("  Es un DocenteInvestigador con "
                        + docenteActual.getNumeroPublicaciones()
                        + " publicaciones");
            }
        }
    }
}