package py.com.progweb.prueba.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import py.com.progweb.prueba.serializers.PointBagDTOSerializer;
import py.com.progweb.prueba.serializers.PointsReportDTOSerializer;

import java.util.Date;

@JsonSerialize(using = PointsReportDTOSerializer.class)
public class PointsReportDTO {

    Integer idCabecera;
    String nombre;
    String apellido;
    Date fecha;
    Integer puntajeUtilizado;
    Integer puntajeUsado;
    String concepto;

    public PointsReportDTO(Integer idCabecera, String nombre, String apellido, Date fecha, Integer puntajeUtilizado, Integer puntajeUsado, String concepto) {
        this.idCabecera = idCabecera;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.puntajeUtilizado = puntajeUtilizado;
        this.puntajeUsado = puntajeUsado;
        this.concepto = concepto;
    }

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getPuntajeUsado() {
        return puntajeUsado;
    }

    public void setPuntajeUsado(Integer puntajeUsado) {
        this.puntajeUsado = puntajeUsado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }



}
