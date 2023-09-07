package br.udesc.quickstart;

import org.junit.jupiter.api.Test;

import br.udesc.quickstart.modelo.TipoTriangulo;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class TrianguloResourceTest {

    @Test
    void testTipoTrianguloEndpoint() {
        var jsonEntrada = "{\"a\": 3, \"b\": 3, \"c\": 3}";
        given()
            .when()
            .contentType(ContentType.JSON)
            .body(jsonEntrada)
            .post("/triangulo/tipo")
            .then()
                .statusCode(200)
                .body(containsString(TipoTriangulo.EQUILATERO.toString()))
            ;
    }

    @Test
    void testNaoFormaTriangulo() {
        var jsonEntrada = "{\"a\": 50, \"b\": 3, \"c\": 3}";
        given()
            .when()
            .contentType(ContentType.JSON)
            .body(jsonEntrada)
            .post("/triangulo/tipo")
            .then()
                .statusCode(400)
                .body(containsString("Não forma triângulo"))
            ;
    }
}
