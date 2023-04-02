package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.RulePoints;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class RulePointsDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public List<RulePoints> lista(){
        Query q = this.em.createQuery("select rp from RulePoints rp");
        return (List<RulePoints>) q.getResultList();
    }

    public void agregar(RulePoints rules){

        this.em.persist(rules);
    }

    public void modificar(RulePoints rp){
        this.em.merge(rp);
    }

    public void eliminar(RulePoints rp){
        rp = em.merge(rp);
        em.remove(rp);
    }
}
