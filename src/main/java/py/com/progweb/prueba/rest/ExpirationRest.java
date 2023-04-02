package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.ExpirationDAO;
import py.com.progweb.prueba.model.Expiration;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("expiration")
@Consumes("application/json")
@Produces("application/json")
public class ExpirationRest {
    @Inject
    ExpirationDAO expirationDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(expirationDAO.listar()).build();
    }

    @POST
    @Path("/")
    public Response crear(Expiration c){
        this.expirationDAO.agregar(c);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Expiration c){
        this.expirationDAO.modificar(c);
        return Response.ok().build();
    }

    @DELETE
    @Path("/")
    public Response eliminar(Expiration c){
        this.expirationDAO.eliminar(c);
        return Response.ok().build();
    }
}
