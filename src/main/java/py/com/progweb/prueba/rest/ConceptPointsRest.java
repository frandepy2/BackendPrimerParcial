package py.com.progweb.prueba.rest;


import py.com.progweb.prueba.ejb.ConceptsPointsDAO;
import py.com.progweb.prueba.model.ConceptsPoints;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("conceptsPoints")
@Consumes("application/json")
@Produces("application/json")
public class ConceptPointsRest {
    @Inject
    ConceptsPointsDAO conceptsPointsDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(conceptsPointsDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response agregar(ConceptsPoints cp){
        this.conceptsPointsDAO.agregar(cp);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(ConceptsPoints cp){
        this.conceptsPointsDAO.modificar(cp);
        return Response.ok().build();
    }

    @DELETE
    @Path("/")
    public Response eliminar(ConceptsPoints cp){
        this.conceptsPointsDAO.eliminar(cp);
        return Response.ok().build();
    }
}
