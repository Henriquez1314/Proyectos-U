package semana10;

public class MainFiguras {

    public static void main(String[] args) {

        Figura circulo = new Circulo(5);
        Figura rectangulo = new Rectangulo(4, 6);
        Figura triangulo = new Triangulo(4, 3);

        System.out.println("Area del circulo: " + circulo.calcularArea());
        System.out.println("Area del rectangulo: " + rectangulo.calcularArea());
        System.out.println("Area del triangulo: " + triangulo.calcularArea());

        Rectangulo r = new Rectangulo(4, 6);
        System.out.println("Area del rectangulo con factor: " + r.calcularArea(2));
    }
}