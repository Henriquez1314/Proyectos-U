package com.uped.sensores;

public class Sensor {
    String unidad = "generica";

    void medir() {
        System.out.println("Midiendo...");
    }

    static String version() {
        return "Sensor v1";
    }
}
