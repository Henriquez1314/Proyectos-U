package com.uped.sensores;

public class MainSensor {
    public static void main(String[] args) {
        Sensor s = new SensorTemperatura();

        System.out.println(s.unidad);
        System.out.println(s.version());
        s.medir();
    }
}
