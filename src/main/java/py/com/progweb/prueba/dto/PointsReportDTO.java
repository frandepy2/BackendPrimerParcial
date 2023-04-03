package py.com.progweb.prueba.dto;

import java.util.Date;

public class PointsReportDTO {

    Integer idCabecera;
    String nombre;
    String apellido;
    Date fecha;
    Integer puntajeUtilizado;
    Integer puntajeUsado;
    String concepto;

    public PointsReportDTO() {
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
