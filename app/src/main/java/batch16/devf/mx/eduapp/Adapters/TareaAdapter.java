package batch16.devf.mx.eduapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import batch16.devf.mx.eduapp.Api.ApiInterface;
import batch16.devf.mx.eduapp.Api.ApiServiceGenerator;
import batch16.devf.mx.eduapp.Models.Alumno;
import batch16.devf.mx.eduapp.Models.Tarea;
import batch16.devf.mx.eduapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gmeono on 19/10/17.
 */

public class TareaAdapter extends RecyclerView.Adapter<TareaAdapter.TareaViewHolder>  {

    List<Tarea> lisTareas;
    ApiInterface apiInterface;
    Alumno alumno;
    Tarea tarea;

    public TareaAdapter(List<Tarea> lisTareas){
        this.lisTareas=lisTareas;
    }


    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        return new TareaViewHolder(view);


    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        tarea= lisTareas.get(position);
        apiInterface.getAllAlumnos().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                for(int i=0; i<response.body().size(); i++){
                    if(response.body().get(i).getId()==tarea.getAlumno_id()){
                        alumno=response.body().get(i);
                    }

                }

            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {

            }
        });

        holder.textViewAlumno.setText(alumno.getNombre()+" " +alumno.getApellido());
        holder.textViewCalificacion.setText(tarea.getCalificacion());
        holder.textViewTarea.setText("Tarea # "+tarea.getNum_tarea());




    }

    @Override
    public int getItemCount() {
        return lisTareas.size();
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


                private TextView textViewTarea;
                private TextView textViewCalificacion;
                private TextView textViewAlumno;

                public TareaViewHolder(View itemView) {
                    super(itemView);
                    apiInterface= ApiServiceGenerator.createService();
                    itemView.setOnClickListener(this);
                    textViewTarea=(TextView)itemView.findViewById(R.id.tv_numeroTarea);
                    textViewAlumno=(TextView)itemView.findViewById(R.id.tv_alumno);
                    textViewCalificacion=(TextView)itemView.findViewById(R.id.tv_calif);

                }

                @Override
                public void onClick(View view) {

                }
            }
}
-