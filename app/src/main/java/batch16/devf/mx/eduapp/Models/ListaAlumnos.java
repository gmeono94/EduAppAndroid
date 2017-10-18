package batch16.devf.mx.eduapp.Models;

/**
 * Created by gmeono on 17/10/17.
 */

public class ListaAlumnos {

    private int id;
    private int cursoId;
    private int alumnoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    @Override
    public String toString() {
        return "ListaAlumnos{" +
                "id=" + id +
                ", cursoId=" + cursoId +
                ", alumnoId=" + alumnoId +
                '}';
    }
}
