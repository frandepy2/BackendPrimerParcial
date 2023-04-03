package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.dto.PointsReportDTO;
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

    public List<PointsReportDTO> listarPorParametros(String concepto, Date fecha, String nro_documento) {
        Query q = this.em.createQuery("select pu.id, c.nombre, c.apellido, pu.fecha, pu.puntajeUtilizado,  d.puntajeUsado, pu.concepto from Detail d " +
                        "join PointsUse pu on pu.id = d.idCabecera " +
                        "join Customer c on c.id = pu.idCliente " +
                        "where pu.concepto = :concepto or date(pu.fecha) = :fecha " +
                        "or c.nroDocumento = :nro_documento ")
                .setParameter("concepto", concepto)
                .setParameter("fecha", fecha, TemporalType.DATE)
                .setParameter("nro_documento", nro_documento);

        return (List<PointsReportDTO>) q.getResultList();
    }

    public List<PointsReportDTO> listarPorParametrosSinFecha(String concepto, String nro_documento) {
        Query q = this.em.createQuery("select pu.id, c.nombre, c.apellido, pu.fecha, pu.puntajeUtilizado,  d.puntajeUsado, pu.concepto from Detail d " +
                        "join PointsUse pu on pu.id = d.idCabecera " +
                        "join Customer c on c.id = pu.idCliente " +
                        "where pu.concepto = :concepto " +
                        "or c.nroDocumento = :nro_documento ")
                .setParameter("concepto", concepto)
                .setParameter("nro_documento", nro_documento);

        return (List<PointsReportDTO>) q.getResultList();
    }

}
