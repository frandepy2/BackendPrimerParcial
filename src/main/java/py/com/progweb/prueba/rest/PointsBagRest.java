package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.DetailDAO;
import py.com.progweb.prueba.ejb.PointBagDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("getBolsaPuntos")
@Consumes("application/json")
@Produces("application/json")
public class PointsBagRest {
    @Inject
    PointBagDAO pointBagDAO;

    @GET
    @Path("/")
    public Response getBolsaPuntos(@QueryParam("min") Integer min,
                                   @QueryParam("max") Integer max,
                                   @QueryParam("cliente") String cliente) {
        // Lógica para consultar los puntos de un cliente
        // en función del concepto de uso, fecha de uso y el cliente en sí.

        return Response.ok(pointBagDAO.listarBolsaPuntos(min, max, cliente)).build();

    }

    @GET
    @Path("/customers/{days}")
    public Response getCustomersByExpirationDate(@PathParam("days") Integer days){
        return Response.ok(pointBagDAO.getCustomersByExpirationDate(days)).build();
    }
}
