package com.induction.RetrofitClass;

import com.induction.DataModel.RetroFitTestApi;
import com.induction.DataModel.UserServiceModel;
import okhttp3.OkHttpClient;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;



public interface Retrofitcallback {

    @GET("/user")
    public Call<List<RetroFitTestApi>> getUsers(
            @Query("per_page") int per_page,
            @Query("page") int page);

    @GET("/user/{id}")
    public Call<RetroFitTestApi> getUser(@Path("id") String username);















}