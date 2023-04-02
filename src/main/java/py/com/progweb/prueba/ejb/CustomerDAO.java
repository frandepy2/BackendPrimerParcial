package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
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

    public List<Customer> buscar(String texto){
        String query = '%'+texto+'%';
        Query q = this.em.createQuery("select c from Customer c where (c.nombre LIKE '"+query+"' or c.apellido LIKE '"+query+"')");
        return (List<Customer>) q.getResultList();
    }

    public List<Customer> buscarPorFecha(Date fecha){
        Query q = this.em.createQuery("select c from Customer c where date(c.fecNacimiento) = :fecha")
                .setParameter("fecha", fecha, TemporalType.DATE);
        return (List<Customer>) q.getResultList();
    }
}
