package batch16.devf.mx.eduapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Api.ApiServiceGenerator;
import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    EditText etUser;
    EditText etPassword;
    Button btnLogin;
    TextView tvRegister;
    ApiInterface apiInterface;
    Spinner spinner;
    Profesor profesor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiInterface= ApiServiceGenerator.createService();
        initComponents();


    }


    public void initComponents(){
        etUser=(EditText) findViewById(R.id.EtUsuario);
        etPassword=(EditText) findViewById(R.id.EtPassword);
        btnLogin=(Button) findViewById(R.id.ButtonLogin);
        tvRegister=(TextView) findViewById(R.id.TextViewRegister);
        spinner=(Spinner)findViewById(R.id.spinner);



       // ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, colors);
        //spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // spinner.setAdapter(spinnerArrayAdapter);




    }

    public void Login(){

        apiInterface.getAllProfesores().enqueue(new Callback<List<Profesor>>() {
            @Override
            public void onResponse(Call<List<Profesor>> call, Response<List<Profesor>> response) {
                for(int i=0; i<response.body().size(); i++){
                    if(response.body().get(i).getNombre().equals(etUser.getText().toString()))
                        profesor=response.body().get(i);
                }
            }

            @Override
            public void onFailure(Call<List<Profesor>> call, Throwable t) {
                    profesor=null;
            }
        });


        if(profesor!=null){
            if(etPassword.getText().toString().equals(profesor.getPassword())){
                //VERIFICAR ALGORITMO DE CIFRADO
                Intent intent = new Intent(this, Curso.class);
                intent.putExtra("profesor",profesor.getUser());
                this.startActivity(intent);
            }else{
                Toast.makeText(this, "Verifica tu usuario y contraseña", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Verifica tu usuario y contraseña", Toast.LENGTH_SHORT).show();
        }





    }
}
