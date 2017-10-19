package batch16.devf.mx.eduapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Api.ApiManager;
import batch16.devf.mx.eduapp.Api.ApiServiceGenerator;
import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Curso curso;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = ApiServiceGenerator.createService();

        Profesor profesor = new Profesor();
        profesor.setNombre("Lucas");
        profesor.setApellido("Filemon");
        profesor.setUser("lucas");
        profesor.setEmail("Federico123@lucas.com");
        profesor.setImagen("noimagen");
        profesor.setPassword("Miniatura25"); //Al menos 8 1 mayus, 1 minuscula

        apiInterface.createProfesor(profesor).enqueue(new Callback<Profesor>() {
            @Override
            public void onResponse(Call<Profesor> call, Response<Profesor> response) {
                Log.e("Error",response.toString());
            }

            @Override
            public void onFailure(Call<Profesor> call, Throwable t) {

            }
        });






    }
}
