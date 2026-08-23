package com.uped.proyecto.modelo;

public class LibroBiblioteca {

    private final String titulo;
    private final String autor;
    private int ejemplaresDisponibles;

    public LibroBiblioteca(String titulo, String autor, int ejemplares) {
        validar(titulo, ejemplares);
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplaresDisponibles = ejemplares;
    }

    public LibroBiblioteca(String titulo, String autor) {
        this(titulo, autor, 1);
    }

    private void validar(String titulo, int ejemplares) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException(
                    "El titulo no puede estar vacio.");
        }

        if (ejemplares < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de ejemplares no puede ser negativa: "
                            + ejemplares);
        }
    }

    public static LibroBiblioteca unico(String titulo, String autor) {
        return new LibroBiblioteca(titulo, autor, 1);
    }

    public boolean prestar() {
        if (ejemplaresDisponibles <= 0) {
            System.out.println(
                    "No hay ejemplares disponibles de: " + titulo);
            return false;
        }

        ejemplaresDisponibles--;

        System.out.println("Prestado: " + titulo
                + " | Quedan: " + ejemplaresDisponibles);

        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }
}