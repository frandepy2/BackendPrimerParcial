package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.CustomerDAO;
import py.com.progweb.prueba.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("customers")
@Consumes("application/json")
@Produces("application/json")
public class CustomerRest {
    @Inject
    CustomerDAO customerDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(customerDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(Customer c){
        this.customerDAO.agregar(c);
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    public Response modificar(Customer c){
        this.customerDAO.modificar(c);
        return Response.ok().build();
    }

    @DELETE
    @Path("/")
    public Response eliminar(Customer c){
        this.customerDAO.eliminar(c);
        return Response.ok().build();
    }
}
