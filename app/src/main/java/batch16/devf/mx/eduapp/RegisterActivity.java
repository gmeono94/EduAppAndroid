package batch16.devf.mx.eduapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import batch16.devf.mx.eduapp.Api.ApiManager;
import batch16.devf.mx.eduapp.Models.Profesor;

public class RegisterActivity extends AppCompatActivity {

    private EditText etnNomRegister;
    private EditText etnApeRegister;
    private EditText etnUsRegister;
    private EditText etnEmaRegister;
    private EditText etnPassRegister;
    private Button btnRegister;
    ApiManager manager= new ApiManager();


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




    }


    public void creaProfesor(){

        Profesor profesor=new Profesor();
        profesor.setNombre(etnNomRegister.getText().toString());
        profesor.setApellido(etnApeRegister.getText().toString());
        profesor.setUser(etnUsRegister.getText().toString());
        profesor.setEmail(etnEmaRegister.getText().toString());
        profesor.setPassword(etnEmaRegister.getText().toString());
        boolean valor =manager.guardaProfesor(profesor);

        if(valor){
            Toast.makeText(RegisterActivity.this,"Usuario creado correctamente",Toast.LENGTH_SHORT);
        }else {
            Toast.makeText(RegisterActivity.this,"Error al crear usuario, verifica tu conexión",Toast.LENGTH_SHORT);
        }


    }


}
