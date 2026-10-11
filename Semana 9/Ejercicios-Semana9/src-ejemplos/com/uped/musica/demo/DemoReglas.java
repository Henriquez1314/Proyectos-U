package com.uped.musica.demo;

public class DemoReglas {

    static class InstrumentoConstructor {
        InstrumentoConstructor() {
            tocar(); // riesgoso: ligadura dinamica durante la construccion
        }

        void tocar() {
            System.out.println("generico");
        }
    }

    static class PianoConstructor extends InstrumentoConstructor {
        String modelo = "Yamaha";

        @Override
        void tocar() {
            System.out.println(modelo);
        }
    }

    static class InstrumentoBase {
        void tocar() {
            System.out.println("sonido base");
        }
    }

    static class GuitarraConAfinar extends InstrumentoBase {
        void afinarCuerdas() {
            System.out.println("Afinando cuerdas (metodo propio de Guitarra)");
        }
    }

    static class InstrumentoSobrecarga {
        void tocar(int volumen) {
            System.out.println("generico (tocar(int))");
        }
    }

    static class PianoSobrecarga extends InstrumentoSobrecarga {
        // Sin @Override: tocar(double) NO sobrescribe tocar(int), lo sobrecarga.
        void tocar(double volumen) {
            System.out.println("piano (tocar(double))");
        }
    }


    static class PrivadaBase {
        private String sonido() {
            return "base-privado";
        }

        String mostrar() {
            return sonido();
        }
    }

    static class PrivadaHija extends PrivadaBase {
        String sonido() {
            return "hija-privado";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 6.1 Constructor llama a metodo sobrescribible ===");
        new PianoConstructor(); // imprime null

        System.out.println();
        System.out.println("=== 6.2 Tipo declarado y downcasting seguro ===");
        InstrumentoBase instr = new GuitarraConAfinar();
        System.out.println("instr.tocar() ->");
        instr.tocar();
        if (instr instanceof GuitarraConAfinar g) {
            g.afinarCuerdas();
        }

        System.out.println();
        System.out.println("=== 6.3 Sobrecarga vs sobrescritura ===");
        PianoSobrecarga p = new PianoSobrecarga();
        p.tocar(5);
        p.tocar(5.0);

        System.out.println();
        System.out.println("=== 5.4 private y despacho dinamico ===");
        PrivadaHija h = new PrivadaHija();
        System.out.println("h.mostrar() -> " + h.mostrar());
        System.out.println("h.sonido() -> " + h.sonido());
    }
}
