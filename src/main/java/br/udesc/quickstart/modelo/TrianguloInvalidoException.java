package br.udesc.quickstart.modelo;

public class TrianguloInvalidoException extends RuntimeException {
    public TrianguloInvalidoException() {
        super("Não forma triângulo");
    }
}
