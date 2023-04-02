package py.com.progweb.prueba.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @Column(name = "id_persona")
    @Basic(optional = false)
    @GeneratedValue(generator = "personaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "personaSec", sequenceName = "persona_sec", allocationSize = 0)
    private Integer idPersona;
    @Column(name = "nombre", length = 50)
    @Basic(optional = false)
    private String nombre;
    @Column(name = "apellido", length = 50)
    @Basic(optional = false)
    private String apellido;

    @OneToMany(mappedBy = "idPersona",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Agenda> listaAgendas;

    @Transient
    private List<Agenda> listaAgendasJson;

    public Persona() {
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Agenda> getListaAgendas() {
        return listaAgendas;
    }

    public void setListaAgendas(List<Agenda> listaAgendas) {
        this.listaAgendas = listaAgendas;
    }

    public List<Agenda> getListaAgendasJson() {
        return listaAgendasJson;
    }

    public void setListaAgendasJson(List<Agenda> listaAgendasJson) {
        this.listaAgendasJson = listaAgendasJson;
    }
}
