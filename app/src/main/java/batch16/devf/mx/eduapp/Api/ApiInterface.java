package batch16.devf.mx.eduapp.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gmeono on 17/10/17.
 */

public interface ApiInterface {

    @GET("/wp-json/wp/v2/posts/{id}")
    public Call<ResponseBody> getPostById(@Path(value="id", encoded = true)String id);
}
