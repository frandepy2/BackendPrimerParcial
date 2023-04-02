package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Persona;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonaDAO {

    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Persona entidad) {
        this.em.persist(entidad);
    }

    public List<Persona> lista(){
        Query q = this.em.createQuery("select p from Persona p");
        return (List<Persona>) q.getResultList();
    }
}