package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Expiration;
import py.com.progweb.prueba.model.PointBag;
import py.com.progweb.prueba.model.RulePoints;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class PointBagDAO {

    @Inject
    CustomerDAO customerDAO;
    @Inject
    RulePointsDAO rulePointsDAO;
    @Inject
    ExpirationDAO expirationDAO;



    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    //Carga de puntos
    public void cargarPuntos(PointBag pb) {
        Integer monto = pb.getMonto();

        //Traemos la fecha de asignacion
        Date fechaAsignacion = new Date();

        //Verificamos el dia de vencimiento y traemos la fecha de caducidad
        Date fechaCaducidad = calcularFechaCaducidad();

        //Verificamos las reglas para calcular los puntos a asignar
        //El saldo es igual a la cantidad de puntos a asignar al principio
        Integer puntosCalculados = calcularPuntos(monto);

        //El estado de los puntos por defecto es PENDING
        pb.setEstado("PENDING");
        pb.setSaldo(puntosCalculados);
        pb.setPuntajeAsignado(puntosCalculados);
        pb.setFechaAsignacion(fechaAsignacion);
        pb.setFechaCaducidad(fechaCaducidad);

        this.em.persist(pb);

    }

    private Date calcularFechaCaducidad(){
        List<Expiration> expiraciones = expirationDAO.listar();
        Date fechaCaducidad = new Date();
        for (Expiration expiration : expiraciones){
            fechaCaducidad = expiration.getFechaFin();
        }

        return fechaCaducidad;
    }

    private Integer calcularPuntos(Integer monto){
        List<RulePoints> reglas = rulePointsDAO.lista();
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
