package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Persona;
import py.com.progweb.prueba.model.PointsUse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PointsUseDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public List<PointsUse> lista(){
        Query q = this.em.createQuery("select pu from PointsUse pu");
        return (List<PointsUse>) q.getResultList();
    }

    public void agregar(PointsUse pu){
        this.em.persist(pu);
    }
}
