package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.PointBagDAO;
import py.com.progweb.prueba.ejb.PointsUseDAO;
import py.com.progweb.prueba.model.PointBag;
import py.com.progweb.prueba.model.PointsUse;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("services")
@Consumes("application/json")
@Produces("application/json")
public class ServiceRest {

    @Inject
    PointBagDAO pointBagDAO;

    @POST
    @Path("/cargar_puntos")
    public Response cargarPuntos(PointBag pointBag){
        this.pointBagDAO.cargarPuntos(pointBag);
        return Response.ok().build();
    }

}
