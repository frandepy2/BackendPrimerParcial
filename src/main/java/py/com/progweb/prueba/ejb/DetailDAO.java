package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Detail;
import py.com.progweb.prueba.model.PointsUse;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class DetailDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public void agregar(Detail detail) {
        this.em.persist(detail);
    }

    public List<Detail> getDetailsByPointUseId(Integer idCabecera) {
        return this.em.createQuery("select d from Detail d where d.idCabecera.id = :param").setParameter("param", idCabecera).getResultList();
    }

    public List<Detail> listarPorParametros(String concepto, Date fecha, String nro_documento) {
        return this.em.createQuery("select pu.id, c.nombre, c.apellido, pu.puntajeUtilizado, d.fecha, d.puntajeUsado from Detail d " +
                        "join PointsUse pu on pu.id = d.idCabecera " +
                        "join Customer c on c.id = pu.idCliente " +
                        "where pu.concepto = :concepto and date(pu.fecha) = :fecha" +
                        "and c.nroDocumento = :nro_documento ")
                .setParameter("concepto", concepto)
                .setParameter("fecha", fecha, TemporalType.DATE)
                .setParameter("nro_documento", nro_documento)
                .getResultList();

    }

}
