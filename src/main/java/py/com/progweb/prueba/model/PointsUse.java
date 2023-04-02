package py.com.progweb.prueba.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="uso_puntos_cab")
public class PointsUse {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "usoPuntosSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "usoPuntosSec", sequenceName = "uso_puntos_cab_sec", allocationSize = 0)
    private Integer idUsoPuntos;
    @Column(name = "id_cliente")
    @Basic(optional = false)
    private Integer idCliente;
    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;
    @Column(name = "fecha")
    @Basic(optional = false)
    private Date fecha;
    @Column(name = "concepto")
    @Basic(optional = false)
    private String concepto;

    public PointsUse() {
    }

    public Integer getIdUsoPuntos() {
        return idUsoPuntos;
    }

    public void setIdUsoPuntos(Integer idUsoPuntos) {
        this.idUsoPuntos = idUsoPuntos;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

}
