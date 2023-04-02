package py.com.progweb.prueba.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clientes")
public class Customer {
    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(generator = "clienteSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="clienteSec", sequenceName = "clientes_sec", allocationSize = 0)
    private Integer idCliente;

    @Column(name = "nombre", length = 255)
    @Basic(optional = false)
    private String nombre;

    @Column(name = "apellido")
    @Basic(optional = false)
    private String apellido;
    @Column(name = "nro_documento")
    @Basic(optional = false)
    private String nroDocumento;
    @Column(name = "tipo_documento")
    @Basic(optional = false)
    private String tipoDocumento;
    @Column(name = "nacionalidad")
    @Basic(optional = false)
    private String nacionalidad;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    @Basic(optional = false)
    private String telefono;
    @Column(name = "fec_nacimiento")
    @Basic(optional = false)
    private Date fecNacimiento;

    public Customer() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
