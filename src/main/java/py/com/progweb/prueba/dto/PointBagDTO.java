package py.com.progweb.prueba.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import py.com.progweb.prueba.serializers.PointBagDTOSerializer;

import javax.persistence.Entity;
import java.util.Date;
@JsonSerialize(using = PointBagDTOSerializer.class)
public class PointBagDTO {

    Integer idBolsa;
    String nombre;
    String apellido;
    private Date fechaAsignacion;
    private Date fechaCaducidad;
    private Integer puntajeAsignado;
    private Integer saldo;
    private Integer monto;
    private String estado;


    public PointBagDTO(Integer idBolsa, String nombre, String apellido, Date fechaAsignacion, Date fechaCaducidad, Integer puntajeAsignado, Integer saldo, Integer monto, String estado) {
        this.idBolsa = idBolsa;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaCaducidad = fechaCaducidad;
        this.puntajeAsignado = puntajeAsignado;
        this.saldo = saldo;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getIdBolsa() {
        return idBolsa;
    }

    public void setIdBolsa(Integer idBolsa) {
        this.idBolsa = idBolsa;
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