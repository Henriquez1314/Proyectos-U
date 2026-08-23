package com.uped.proyecto.modelo;

public class ConfiguracionReporte {

    private final String titulo;
    private final String formato;
    private final boolean incluirGraficos;
    private final boolean incluirDetalles;

    private ConfiguracionReporte(Builder builder) {
        this.titulo = builder.titulo;
        this.formato = builder.formato;
        this.incluirGraficos = builder.incluirGraficos;
        this.incluirDetalles = builder.incluirDetalles;
    }

    public static class Builder {

        private String titulo = "Reporte";
        private String formato = "PDF";
        private boolean incluirGraficos = false;
        private boolean incluirDetalles = false;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder formato(String formato) {
            this.formato = formato;
            return this;
        }

        public Builder incluirGraficos(boolean incluirGraficos) {
            this.incluirGraficos = incluirGraficos;
            return this;
        }

        public Builder incluirDetalles(boolean incluirDetalles) {
            this.incluirDetalles = incluirDetalles;
            return this;
        }

        public ConfiguracionReporte build() {
            return new ConfiguracionReporte(this);
        }
    }

    @Override
    public String toString() {
        return "ConfiguracionReporte{" +
                "titulo='" + titulo + '\'' +
                ", formato='" + formato + '\'' +
                ", incluirGraficos=" + incluirGraficos +
                ", incluirDetalles=" + incluirDetalles +
                '}';
    }
}