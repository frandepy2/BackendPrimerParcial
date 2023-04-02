package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.RulePointsDAO;
import py.com.progweb.prueba.model.RulePoints;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("rules")
@Consumes("application/json")
@Produces("application/json")
public class RulePointsRest {
    @Inject
    RulePointsDAO rulesDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(rulesDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(RulePoints rp){
        this.rulesDAO.agregar(rp);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(RulePoints rp){
        this.rulesDAO.modificar(rp);
        return Response.ok().build();
    }

    @DELETE
    @Path("/")
    public Response eliminar(RulePoints rp){
        this.rulesDAO.eliminar(rp);
        return Response.ok().build();
    }

}
