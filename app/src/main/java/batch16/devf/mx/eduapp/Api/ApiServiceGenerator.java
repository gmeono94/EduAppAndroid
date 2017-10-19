package batch16.devf.mx.eduapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gmeono on 17/10/17.
 */

public class ApiServiceGenerator {


    private static Retrofit retrofit;

    private static Retrofit.Builder builder= new Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
            baseUrl("https://151ae154.ngrok.io");

    public static ApiInterface createService(){
        if(retrofit == null )
            retrofit =builder.build();

        return retrofit.create(ApiInterface.class);
    }

}
