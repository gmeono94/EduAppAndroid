package batch16.devf.mx.eduapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import batch16.devf.mx.eduapp.Adapters.TareaAdapter;
import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import batch16.devf.mx.eduapp.Models.Tarea;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CursoActivity extends AppCompatActivity {

    String userProfesor;
    Profesor profesor;
    Curso curso;
    ApiInterface apiInterface;
    RecyclerView recyclerTareas;
    TareaAdapter adapter;
    List<Tarea> tarea = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Intent intent = this.getIntent();
        userProfesor=intent.getStringExtra("profesor");

    }


    public void initCursoByProfesor(){

        apiInterface.getAllProfesores().enqueue(new Callback<List<Profesor>>() {
            @Override
            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {
                for(int i=0; i<response.body().size(); i++){
                    if(response.body().get(i).getNombre().equals(userProfesor))
                        profesor=response.body().get(i);
                }
            }

            @Override
            public void onFailure(Call<List<Profesor>> call, Throwable t) {
                profesor=null;
            }
        });


        if(profesor!=null){

            apiInterface.getAllCursos().enqueue(new Callback<List<Curso>>() {
                @Override
                public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                    for (int i=0; i<response.body().size(); i++){
                        if(response.body().get(i).getMaestroId()==profesor.getId())
                            curso=response.body().get(i);
                    }
                }

                @Override
                public void onFailure(Call<List<Curso>> call, Throwable t) {

                }
            });

        }else{
            Toast.makeText(this, "Verifica tus datos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);

        }

    }

    public void initAdaptador(){

        apiInterface.getAllTarea().enqueue(new Callback<List<Tarea>>() {
            @Override
            public void onResponse(Call<List<Tarea>> call, Response<List<Tarea>> response) {
                for(int i=0; i<response.body().size(); i++){
                    if(response.body().get(i).getCurso_id()==curso.getId())
                        tarea.add(response.body().get(i));
                }
            }

            @Override
            public void onFailure(Call<List<Tarea>> call, Throwable t) {

            }
        });

        recyclerTareas= (RecyclerView) findViewById(R.id.rv_itemTareas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerTareas.setLayoutManager(layoutManager);

        recyclerTareas.setHasFixedSize(true);

        adapter= new TareaAdapter(tarea);

        recyclerTareas.setAdapter(adapter);





    }

}
