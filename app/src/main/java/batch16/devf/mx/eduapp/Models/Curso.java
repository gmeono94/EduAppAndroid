package batch16.devf.mx.eduapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by gmeono on 17/10/17.
 */

public class Curso {



    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("horario")
    @Expose
    private String horario;
    @SerializedName("temario")
    @Expose
    private String temario;
    @SerializedName("maestro")
    @Expose
    private int maestroId;
    @SerializedName("materia")
    @Expose
    private int materiaId;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaestroId() {
        return maestroId;
    }

    public void setMaestroId(int maestroId) {
        this.maestroId = maestroId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTemario() {
        return temario;
    }

    public void setTemario(String temario) {
        this.temario = temario;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", maestroId=" + maestroId +
                ", materiaId=" + materiaId +
                ", nombre='" + nombre + '\'' +
                ", horario='" + horario + '\'' +
                ", temario='" + temario + '\'' +
                '}';
    }
}
