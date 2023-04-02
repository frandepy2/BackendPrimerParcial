package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bolsa_puntos")
public class PointBag {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "bolsaPuntosSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="bolsaPuntosSec", sequenceName = "bolsa_puntos_sec", allocationSize = 0)
    private Integer idBolsa;

    @Column(name = "id_cliente")
    @Basic(optional = false)
    private Integer idCliente;
    @Column(name = "fecha_asignacion")
    @Basic(optional = false)
    private Date fechaAsignacion;
    @Column(name = "fecha_caducidad")
    @Basic(optional = false)
    private Date fechaCaducidad;
    @Column(name = "puntaje_asignado")
    @Basic(optional = false)
    private Integer puntajeAsignado;
    @Column(name = "saldo")
    @Basic(optional = false)
    private Integer saldo;
    @Column(name = "monto")
    @Basic(optional = false)
    private Integer monto;
    @Column(name = "estado")
    @Basic(optional = false)
    private String estado;

    public PointBag() {
    }

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(Integer puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
