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

    public Integer calcularPuntos(Integer monto){
        List<RulePoints> reglas = this.lista();

        Integer montoEquivalencia;

        for (RulePoints regla : reglas){
            if (regla.getLimiteSuperior() != null) {
                if (regla.getLimiteInferior() <= monto && regla.getLimiteSuperior() >= monto) {
                    montoEquivalencia = regla.getEquivalencia();
                    return monto/montoEquivalencia;
                }
            }else{
                //Si es null el limite superior
                if(regla.getLimiteInferior() <= monto ){
                    montoEquivalencia = regla.getEquivalencia();
                    return monto/montoEquivalencia;
                }
            }
        }
        //Caso contrario retorna 0
        return 0;
    }
}
