package py.com.progweb.prueba.shedule;

import py.com.progweb.prueba.ejb.PointBagDAO;
import py.com.progweb.prueba.model.PointBag;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Singleton
public class ExpirationShedule {

    @Inject
    PointBagDAO pointBagDAO;

    @Schedule(hour = "*", minute = "*/2", second = "0", persistent = false)
    public void actualizarPuntos() {
        System.out.println("Inicia el proceso para actualizar los puntos expirados");
        Date fechaActual = new Date();

        List<PointBag> pendingPoints = pointBagDAO.getPendingPoints();

        Integer puntosExpirados = 0;

        for (PointBag point : pendingPoints){
            Date fechaCaducidad = point.getFechaCaducidad();
            //Comparamos la fechas de date;
            if (fechaCaducidad.compareTo(fechaActual) < 0){
                point.setEstado("EXPIRED");
                pointBagDAO.modificar(point);
                puntosExpirados +=1;
            }
        }
        System.out.println("Se desactivaron "+puntosExpirados+" puntos asignados");
        System.out.println("Fin del proceso de actualizacion de Puntos");
    }
}
