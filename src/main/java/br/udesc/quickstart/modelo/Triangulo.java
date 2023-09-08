package br.udesc.quickstart.modelo;

public class Triangulo {
    private double a;
    private double b;
    private double c;

    public Triangulo() {}

    public Triangulo(double a, double b, double c) {
        if (!ladosFormamTriangulo(a, b, c)) {
            throw new TrianguloInvalidoException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

    public void setA(double a) { this.a = a; }
    public void setB(double b) { this.b = b; }
    public void setC(double c) { this.c = c; }

    public static boolean ladosFormamTriangulo(double a, double b, double c) {
        return (a < (b + c))
            && (b < (a + c))
            && (c < (a + b));
    }

    public TipoTriangulo tipo() {
        if (a == b && b == c)
            return TipoTriangulo.EQUILATERO;
        if (a == b || b == c || a == c)
            return TipoTriangulo.ISOSCELES;
        return TipoTriangulo.ESCALENO;
    }
}
