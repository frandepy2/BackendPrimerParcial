package py.com.progweb.prueba.rest;

import py.com.progweb.prueba.ejb.CustomerDAO;
import py.com.progweb.prueba.ejb.DetailDAO;
import py.com.progweb.prueba.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("consultarPuntos")
@Consumes("application/json")
@Produces("application/json")
public class PointsRest {
    @Inject
    DetailDAO detailDAO;

    @GET
    @Path("/")
    public Response consultarPuntos(@QueryParam("concepto") String concepto,
                                        @QueryParam("fecha") String fecha,
                                        @QueryParam("cliente") String cliente) {
        // Lógica para consultar los puntos de un cliente
        // en función del concepto de uso, fecha de uso y el cliente en sí.
       if (fecha != null) {
           try {
               SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
               Date date = dateFormat.parse(fecha);

               return Response.ok(detailDAO.listarPorParametros(concepto, date, cliente)).build();
           } catch (ParseException e) {
               // Handle the parse exception
               return Response.status(Response.Status.BAD_REQUEST)
                       .entity("Invalid date format. Please use yyyy-MM-dd.").build();
           }
       }else{
           return Response.ok(detailDAO.listarPorParametrosSinFecha(concepto, cliente)).build();
       }
    }
}
