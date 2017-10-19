package batch16.devf.mx.eduapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Api.ApiServiceGenerator;
import batch16.devf.mx.eduapp.Models.Curso;
import batch16.devf.mx.eduapp.Models.Profesor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Curso curso;
    ApiInterface apiInterface;
    Button btnProfesor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfesor=(Button)findViewById(R.id.ButtonProfesor);
        btnProfesor.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ButtonProfesor:
                Intent intent = new Intent(this,LoginActivity.class);
                this.startActivity(intent);
            break;
        }

    }
}
