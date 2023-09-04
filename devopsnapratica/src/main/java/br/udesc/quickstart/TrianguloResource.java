package br.udesc.quickstart;

import br.udesc.quickstart.modelo.Triangulo;
import br.udesc.quickstart.modelo.TrianguloInvalidoException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/triangulo")
public class TrianguloResource {

    @POST
    @Path("/tipo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response verificaTriangulo(Triangulo in) {
        Triangulo triangulo;
        try {
            triangulo = new Triangulo(in.getA(), in.getB(), in.getC());
        } catch (TrianguloInvalidoException e) {
            return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build();
        }
        return Response
            .ok(triangulo.tipo())
            .build();
    }
    
}
