package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.dto.UsePointsDTO;
import py.com.progweb.prueba.ejb.PointBagDAO;
import py.com.progweb.prueba.ejb.PointsUseDAO;
import py.com.progweb.prueba.ejb.RulePointsDAO;
import py.com.progweb.prueba.model.PointBag;
import py.com.progweb.prueba.model.PointsUse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("services")
@Consumes("application/json")
@Produces("application/json")
public class ServiceRest {

    @Inject
    PointBagDAO pointBagDAO;

    @Inject
    RulePointsDAO rulePointsDAO;

    @POST
    @Path("/cargar_puntos")
    public Response cargarPuntos(PointBag pointBag){
        this.pointBagDAO.cargarPuntos(pointBag);
        return Response.ok().build();
    }

    @POST
    @Path("/usar_puntos")
    public Response usarPuntos(UsePointsDTO usePointsDTO){
        this.pointBagDAO.utilizarPuntos(usePointsDTO);
        return Response.ok().build();
    }

    @GET
    @Path("/calcular/{monto}")
    public Response consultarPuntos(@PathParam("monto") Integer amount){
        return Response.ok("Cantidad de puntos por el monto ingresado : " +  rulePointsDAO.calcularPuntos(amount)).build();
    }
}
