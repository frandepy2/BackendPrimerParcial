package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Expiration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Stateless
public class ExpirationDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Expiration ex){
        calculateDays(ex);

        this.em.persist(ex);
    }

    private void calculateDays(Expiration ex) {
        Date fechaInicio = ex.getFechaInicio();
        Date fechaFin = ex.getFechaFin();

        LocalDate inicio = fechaInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fin = fechaFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Integer dias = Math.toIntExact(ChronoUnit.DAYS.between(inicio, fin));

        ex.setDiasDuracion(dias);
    }

    public List<Expiration> listar(){
        Query q = this.em.createQuery("select ex from Expiration ex");
        return (List<Expiration>) q.getResultList();
    }

    public void modificar(Expiration ex){

        calculateDays(ex);
        this.em.merge(ex);
    }

    public void eliminar(Expiration ex){
        ex = em.merge(ex);
        em.remove(ex);
    }
}
