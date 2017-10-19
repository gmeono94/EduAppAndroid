package batch16.devf.mx.eduapp.Models;

/**
 * Created by gmeono on 17/10/17.
 */

public class Tarea {

    private int id;
    private int curso_id;
    private int num_tarea;
    private String descripcion;
    private int calificacion;
    private int alumno_id;


    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getNum_tarea() {
        return num_tarea;
    }

    public void setNum_tarea(int num_tarea) {
        this.num_tarea = num_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", curso_id=" + curso_id +
                ", num_tarea=" + num_tarea +
                ", descripcion='" + descripcion + '\'' +
                ", calificacion=" + calificacion +
                ", alumno_id=" + alumno_id +
                '}';
    }
}
