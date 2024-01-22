
package Modelo;


import java.sql.Time;
import javafx.beans.property.*;

public class Articulo {

    String codigo;// alfanumérico
    String descripcion;
    float pvp;
    float gastosEnvio;
    int tiempoDePreparacion;// minutos

    // constructor por defecto:
    public Articulo() {
        this.codigo = "-";
        this.descripcion = "-";
        this.pvp = 0.0f;
        this.gastosEnvio = 0.0f;
        this.tiempoDePreparacion = 0;
    }

    // constructor segundo:
    public Articulo(String codigo, String descripcion, float gastosEnvio, float pvp, int tiempoDePreparacion) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPvp(pvp);
        setGastosEnvio(gastosEnvio);
        setTiempoDePreparacion(tiempoDePreparacion);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public float getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoDePreparacion() {
        return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion) {
        this.tiempoDePreparacion = tiempoDePreparacion;
    }

    public String toString() {// descripción simplificada del artículo
        String str = "Art: " + this.getCodigo();
        str+= "\n\tDescripción: " +this.getDescripcion();
        str += "\n\tPrecio: " + Float.toString(this.getPvp());
        str += "\n\tGastos de envío: "+getGastosEnvio();
        str+="\n\tTiempo de preparación (minutos):"+getTiempoDePreparacion();
        return str;
    }

}
   
