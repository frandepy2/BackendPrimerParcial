package py.com.progweb.prueba.model;

import javax.persistence.*;
@Entity
@Table(name="uso_puntos_det")
public class Detail {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "usoPuntosDetalleSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "usoPuntosDetalleSec", sequenceName = "uso_puntos_det_sec", allocationSize = 0)
    private Integer idDetalle;
    @JoinColumn(name = "id_cabecera",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PointsUse idCabecera;
    @Basic(optional = false)
    @Column(name = "puntaje_usado")
    private Integer puntajeUsado;
    @Basic(optional = false)
    @Column(name = "id_bolsa")
    private Integer idBolsa;

    public Detail() {
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public PointsUse getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(PointsUse idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Integer getPuntajeUsado() {
        return puntajeUsado;
    }

    public void setPuntajeUsado(Integer puntajeUsado) {
        this.puntajeUsado = puntajeUsado;
    }

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
    }
}
