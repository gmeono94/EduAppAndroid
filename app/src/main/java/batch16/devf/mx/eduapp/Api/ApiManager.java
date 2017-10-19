package batch16.devf.mx.eduapp.Api;

import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gmeono on 18/10/17.
 */

public class ApiManager {

    private ApiInterface servicesInterface;
    private List<Profesor> profesores;
    private Curso curso;
    private Boolean valor;

    public ApiManager(){
        servicesInterface = ApiServiceGenerator.createService();
        curso=new Curso();
    }


    public List<Profesor> getArrayProfesores(){



        servicesInterface.getAllProfesores().enqueue(new Callback<List<Profesor>>() {
            @Override
            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {

                profesores=response.body();
            }

            @Override
            public void onFailure(Call<List<Profesor>> call, Throwable t) {
                    profesores=null;
            }

        });

        return profesores;


    }

    public int getNuevaId(){
        return getArrayProfesores().size();
    }

    public boolean guardaProfesor(Profesor profesor){


        servicesInterface.createProfesor(profesor).enqueue(new Callback<Profesor>() {
            @Override
            public void onResponse(Call<Profesor> call, Response<Profesor> response) {
            valor=true;

            }

            @Override
            public void onFailure(Call<Profesor> call, Throwable t) {
            valor=false;
            }
        });

        return valor;


    }


    public Curso getCursoById(int id){

        servicesInterface.getCursoById(id).enqueue(new Callback<Curso>() {
            @Override
            public void onResponse(Call<Curso> call, Response<Curso> response) {
                curso=response.body();
                Log.e("Error",curso.toString());
            }

            @Override
            public void onFailure(Call<Curso> call, Throwable t) {
                    curso=null;
                Log.e("Error2",curso.toString());

            }
        });

        return curso;

    }





}
