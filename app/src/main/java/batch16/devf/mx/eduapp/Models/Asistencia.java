package batch16.devf.mx.eduapp.Models;

/**
 * Created by gmeono on 17/10/17.
 */

public class Asistencia {

    private int id;
    private int alumnoId;
    private int cursoId;
    private String fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "id=" + id +
                ", alumnoId=" + alumnoId +
                ", cursoId=" + cursoId +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
