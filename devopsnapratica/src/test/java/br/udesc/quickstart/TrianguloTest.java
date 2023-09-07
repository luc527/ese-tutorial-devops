package br.udesc.quickstart;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import br.udesc.quickstart.modelo.TipoTriangulo;
import br.udesc.quickstart.modelo.Triangulo;
import br.udesc.quickstart.modelo.TrianguloInvalidoException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class TrianguloTest {

    @Test
    void deveCriarTriangulo() {
        var a = 3;
        var b = 4;
        var c = 5;

        var triangulo = new Triangulo(a, b, c);

        assertNotNull(triangulo);

        assertEquals(a, triangulo.getA());
        assertEquals(b, triangulo.getB());
        assertEquals(c, triangulo.getC());
    }

    private record TrianguloArgumentos(int a, int b, int c) {}

    @Test
    void deveProibirCriarTrianguloInvalido() {
        var arglist = new TrianguloArgumentos[]{
            new TrianguloArgumentos(3, 4, 50),
            new TrianguloArgumentos(3, 50, 4),
            new TrianguloArgumentos(4, 3, 50),
            new TrianguloArgumentos(4, 50, 3),
            new TrianguloArgumentos(50, 3, 4),
            new TrianguloArgumentos(50, 4, 3),
        };
        for (var args : arglist) {
            var a = args.a();
            var b = args.b();
            var c = args.c();
            var e = assertThrows(TrianguloInvalidoException.class, () -> {
                new Triangulo(a, b, c);
            });
            assertEquals("Não forma triângulo", e.getMessage());
        }
    }

    @Test
    void deveVerificarSeTrianguloEhEquilatero() {
        var triangulo = new Triangulo(4, 4, 4);
        assertEquals(TipoTriangulo.EQUILATERO, triangulo.tipo());
    }

    @Test
    void deveVerificarSeTrianguloEhIsosceles() {
        var triangulos = new Triangulo[]{
            new Triangulo(4, 4, 5),
            new Triangulo(5, 4, 4),
            new Triangulo(4, 5, 4),
        };
        for (var triangulo : triangulos) {
            assertEquals(triangulo.tipo(), TipoTriangulo.ISOSCELES);
        }
    }

    @Test
    void deveVerificarSeTrianguloEhEscaleno() {
        var triangulo = new Triangulo(3, 4, 5);
        assertEquals(TipoTriangulo.ESCALENO, triangulo.tipo());
    }
}
