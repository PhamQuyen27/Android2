package cf.vandit.streamingapp_nhom12.request;

import cf.vandit.streamingapp_nhom12.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static ApiInterface apiInterface = retrofit.create(ApiInterface.class);

    public static ApiInterface getMovieApi() {
        return apiInterface;
    }
}
