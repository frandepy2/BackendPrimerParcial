package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.CustomerDAO;
import py.com.progweb.prueba.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("search")
@Consumes("application/json")
@Produces("application/json")
public class SearchRest {
    @Inject
    CustomerDAO customerDAO;

    @GET
    @Path("/customers")
    public Response buscarCliente(@QueryParam("q") String q, @QueryParam("type") String type){
        try{
            List<Customer> customers = new ArrayList<>();

            if(type == null){
                customers = this.customerDAO.buscar(q);
            }else if(type.compareTo("fecha") == 0){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(q);
                customers = this.customerDAO.buscarPorFecha(date);
            }

            return Response.ok(customers).build();
        } catch (ParseException e) {
            // Handle the parse exception
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid date format. Please use yyyy-MM-dd.").build();
        }
    }
}
