package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CustomerDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Customer entidad) {
        this.em.persist(entidad);
    }

    public List<Customer> lista(){
        Query q = this.em.createQuery("select c from Customer c");
        return (List<Customer>) q.getResultList();
    }

    public void modificar(Customer entidad) {
        this.em.merge(entidad);
    }

    public void eliminar(Customer entidad) {
        entidad = em.merge(entidad);
        em.remove(entidad);
    }
}
