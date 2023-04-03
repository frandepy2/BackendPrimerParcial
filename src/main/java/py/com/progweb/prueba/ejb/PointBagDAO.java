package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.dto.PointBagDTO;
import py.com.progweb.prueba.dto.PointsReportDTO;
import py.com.progweb.prueba.dto.UsePointsDTO;
import py.com.progweb.prueba.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
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

    @Inject
    ConceptsPointsDAO conceptsPointsDAO;





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

    //Utilizar Puntos
    public void utilizarPuntos(UsePointsDTO solicitud){
        Integer idCliente = solicitud.getIdCliente();
        Integer idConcepto = solicitud.getIdConceptoPuntos();

        //Traemos el concepto por idCliente
        ConceptsPoints concepto = conceptsPointsDAO.getConceptsPointsById(idConcepto);

        //Obtenemos la cantidad de puntos requeridos en una variable auxiliar
        Integer puntosRequeridos = concepto.getPuntosRequeridos();
        Integer totPuntosUsados = 0;

        //Obtenemos todos los puntos del cliente en forma de FIFO
        List<PointBag> puntosCliente = this.getPointsByCustomerId(idCliente);

        //Creamos la cabecera
        PointsUse cabecera = new PointsUse();
        cabecera.setConcepto(concepto.getDescripcion());
        cabecera.setPuntajeUtilizado(concepto.getPuntosRequeridos());
        cabecera.setFecha(new Date());
        cabecera.setIdCliente(idCliente);

        //Guardamos la cabecera en base de datos y obtenemos el id
        this.em.persist(cabecera);

        //Por cada elemento de la lista
        for (PointBag punto : puntosCliente){
            //Sumamos los puntos del punto a totPuntosUsados
            totPuntosUsados += punto.getSaldo();
            if (totPuntosUsados <= puntosRequeridos){
                //Creamos el detalle
                Detail detalle = new Detail();
                detalle.setIdCabecera(cabecera);
                detalle.setIdBolsa(punto.getIdBolsa());
                detalle.setPuntajeUsado(punto.getSaldo());

                punto.setSaldo(0);
                punto.setEstado("USED");
                this.em.merge(punto);
                this.em.persist(detalle);
            }else{
                //Supero los puntos se descuenta solo del saldo de punto los puntos necesarios hasta puntos requeridos
                Integer puntosRestantes = puntosRequeridos - (totPuntosUsados - punto.getSaldo());
                punto.setSaldo(punto.getSaldo()-puntosRestantes);
                this.em.merge(punto);

                //Creamos el detalle con la cantidad de puntos utilizados de este punto
                Detail detalle = new Detail();
                detalle.setIdCabecera(cabecera);
                detalle.setIdBolsa(punto.getIdBolsa());
                detalle.setPuntajeUsado(puntosRestantes);

                //Persistimos el detalle en la base de datos
                this.em.persist(detalle);

                //Terminamos el loop
                break;
            }
        }
    }

    private List<PointBag> getPointsByCustomerId(Integer customerId) {
        Query q = this.em.createQuery("SELECT pb FROM PointBag pb WHERE pb.idCliente = :customerIdParam and pb.estado = 'PENDING' ORDER BY pb.idBolsa ASC");
        q.setParameter("customerIdParam", customerId);
        List<PointBag> results = q.getResultList();
        return results;
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

    public List<PointBagDTO> listarBolsaPuntos(Integer min, Integer max, String nro_documento) {
        Query q = this.em.createQuery("select new py.com.progweb.prueba.dto.PointBagDTO(pg.id, c.nombre, c.apellido, pg.fechaAsignacion, pg.fechaCaducidad, " +
                        "pg.puntajeAsignado, pg.saldo, pg.monto, pg.estado) from PointBag pg " +
                        "join Customer c on c.id = pg.idCliente " +
                        "where pg.puntajeAsignado between :min and :max " +
                        "or c.nroDocumento = :nro_documento ")
                .setParameter("max", max)
                .setParameter("min", min)
                .setParameter("nro_documento", nro_documento);

        return (List<PointBagDTO>) q.getResultList();
    }
}
