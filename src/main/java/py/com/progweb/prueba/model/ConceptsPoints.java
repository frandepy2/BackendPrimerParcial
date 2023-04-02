package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name="concepto_puntos")
public class ConceptsPoints {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "conceptoSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "conceptoSec", sequenceName = "conceptos_sec", allocationSize = 0)
    private Integer idConceptoPuntos;
    @Column(name = "descripcion", length = 255)
    @Basic(optional = false)
    private String descripcion;
    @Column(name = "puntos_requeridos", length = 255)
    @Basic(optional = false)
    private Integer puntosRequeridos;

    public ConceptsPoints() {
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdConceptoPuntos() {
        return idConceptoPuntos;
    }

    public void setIdConceptoPuntos(Integer idConceptoPuntos) {
        this.idConceptoPuntos = idConceptoPuntos;
    }
}
