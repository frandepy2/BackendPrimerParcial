package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "vencimiento")
public class Expiration {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "vencimientoSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="vencimientoSec", sequenceName = "vencimiento_sec", allocationSize = 0)
    private Integer idVencimiento;

    @Column(name = "fecha_inicio")
    @Basic(optional = false)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Basic(optional = false)
    private Date fechaFin;
    @Column(name = "dias_duracion")
    @Basic(optional = false)
    private Integer diasDuracion;

    public Expiration() {
    }

    public Integer getIdVencimiento() {
        return idVencimiento;
    }

    public void setIdVencimiento(Integer idVencimiento) {
        this.idVencimiento = idVencimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(Integer diasDuracion) {
        this.diasDuracion = diasDuracion;
    }
}
