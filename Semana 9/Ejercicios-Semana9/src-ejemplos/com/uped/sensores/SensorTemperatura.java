package com.uped.sensores;

public class SensorTemperatura extends Sensor {
    String unidad = "celsius";

    @Override
    void medir() {
        System.out.println("25.4 " + unidad);
    }

    static String version() {
        return "SensorTemperatura v2";
    }
}
