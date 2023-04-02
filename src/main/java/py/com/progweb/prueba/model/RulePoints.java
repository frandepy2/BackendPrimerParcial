package py.com.progweb.prueba.model;

import javax.persistence.*;

@Entity
@Table(name= "reglas_puntos")
public class RulePoints {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "reglasPuntosSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "reglasPuntosSec", sequenceName = "reglas_puntos_sec", allocationSize = 0)
    private Integer idRegla;

    @Column(name = "limite_inferior")
    private Integer limiteInferior;
    @Column(name = "limite_superior")
    private Integer limiteSuperior;
    @Column(name = "monto_equivalencia")
    private Integer equivalencia;

    public RulePoints() {
    }

    public Integer getIdRegla() {
        return idRegla;
    }

    public void setIdRegla(Integer idRegla) {
        this.idRegla = idRegla;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Integer getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(Integer equivalencia) {
        this.equivalencia = equivalencia;
    }
}
