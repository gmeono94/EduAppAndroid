package batch16.devf.mx.eduapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Api.ApiServiceGenerator;
import batch16.devf.mx.eduapp.Models.Profesor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etnNomRegister;
    private EditText etnApeRegister;
    private EditText etnUsRegister;
    private EditText etnEmaRegister;
    private EditText etnPassRegister;
    private Button btnRegister;
    ApiInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        etnNomRegister=(EditText)findViewById(R.id.EtNombreRegistro);
        etnApeRegister=(EditText)findViewById(R.id.EtApellidoRegistro);
        etnUsRegister=(EditText)findViewById(R.id.EtUsuarioRegistro);
        etnEmaRegister=(EditText)findViewById(R.id.EtEmailRegistro);
        etnPassRegister=(EditText)findViewById(R.id.EtPasswordRegistro);
        btnRegister=(Button)findViewById(R.id.ButtonRegister);

        apiInterface= ApiServiceGenerator.createService();
        btnRegister.setOnClickListener(this);





    }


    public void creaProfesor(){

        Profesor profesor=new Profesor();
        profesor.setNombre(etnNomRegister.getText().toString());
        profesor.setApellido(etnApeRegister.getText().toString());
        profesor.setUser(etnUsRegister.getText().toString());
        profesor.setEmail(etnEmaRegister.getText().toString());
        profesor.setPassword(etnPassRegister.getText().toString());

        apiInterface.createProfesor(profesor).enqueue(new Callback<Profesor>() {
            @Override
            public void onResponse(Call<Profesor> call, Response<Profesor> response) {
                Toast.makeText(RegisterActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Profesor> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Verifica tu usuario y recuerda usar una contraseña segura", Toast.LENGTH_SHORT).show();

            }
        });









    }


    @Override
    public void onClick(View view) {
        creaProfesor();
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }
}
