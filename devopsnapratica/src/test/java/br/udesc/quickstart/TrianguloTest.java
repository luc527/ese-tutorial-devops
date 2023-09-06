package br.udesc.quickstart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.udesc.quickstart.modelo.TipoTriangulo;
import br.udesc.quickstart.modelo.Triangulo;
import br.udesc.quickstart.modelo.TrianguloInvalidoException;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TrianguloTest {

    @Test
    void deveCriarTriangulo() {
        var a = 3;
        var b = 4;
        var c = 5;

        var triangulo = new Triangulo(a, b, c);

        assertTrue(triangulo != null);

        assertEquals(a, triangulo.getA());
        assertEquals(b, triangulo.getB());
        assertEquals(c, triangulo.getC());
    }

    @Test
    void deveProibirCriarTrianguloInvalido() {
        var e = assertThrows(TrianguloInvalidoException.class, () -> {
            new Triangulo(3, 4, 50);
        });
        assertEquals("Não forma triângulo", e.getMessage());
    }

    @Test
    void deveVerificarSeTrianguloEhEquilatero() {
        var triangulo = new Triangulo(4, 4, 4);
        assertEquals(TipoTriangulo.EQUILATERO, triangulo.tipo());
    }

    @Test
    void deveVerificarSeTrianguloEhIsosceles() {
        var triangulo = new Triangulo(4, 4, 5);
        assertEquals(TipoTriangulo.ISOSCELES, triangulo.tipo());
    }

    @Test
    void deveVerificarSeTrianguloEhEscaleno() {
        var triangulo = new Triangulo(3, 4, 5);
        assertEquals(TipoTriangulo.ESCALENO, triangulo.tipo());
    }
}
