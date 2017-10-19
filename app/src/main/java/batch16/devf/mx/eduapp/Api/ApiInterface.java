package batch16.devf.mx.eduapp.Api;



import java.util.List;

import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by gmeono on 17/10/17.
 */

public interface ApiInterface {


    @GET("/api/v1/maestro/")
    Call<List<Profesor>> getAllProfesores();

    @POST("/api/v1/maestro/")
    Call<Profesor> createProfesor(@Body Profesor profesor);

    @GET("/api/v1/maestro/{id}")
    public Call<ResponseBody> getProfesorById(@Path(value="id", encoded = true)String id);

    @GET("/api/v1/curso/")
    Call<List<Curso>> getAllCursos();

    @POST("/api/v1/curso/")
    Call<Curso> createCurso(@Body Curso curso);

    @GET("/api/v1/maestro/{id}")
    public Call<Curso> getCursoById(@Path(value="id")int id);




}
