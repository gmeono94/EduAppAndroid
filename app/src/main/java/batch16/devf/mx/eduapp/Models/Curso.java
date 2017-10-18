package batch16.devf.mx.eduapp.Models;

/**
 * Created by gmeono on 17/10/17.
 */

public class Curso {
    private int id;
    private int maestroId;
    private int materiaId;
    private String nombre;
    private String horario;
    private String temario;

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
