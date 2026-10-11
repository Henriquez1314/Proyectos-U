package com.uped.violin;

public class MainViolin {
    public static void main(String[] args) {
        Instrumento v = new Violin();

        System.out.println(v.tipo);
        System.out.println(v.catalogo());
        v.tocar();
    }
}
