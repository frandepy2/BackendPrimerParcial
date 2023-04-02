package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Detail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DetailDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Detail detail){
        this.em.persist(detail);
    }

    public List<Detail> getDetailsByPointUseId(Integer idCabecera){
        return this.em.createQuery("select d from Detail d where d.idCabecera.id = :param").setParameter("param",idCabecera).getResultList();
    }

}
