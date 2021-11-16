package com.induction;


import com.induction.Baranidharan.TestDb;
import com.induction.DataModel.RetroFitTestApi;
import com.induction.Repository.StudentRepository;
import com.induction.RetrofitClass.Retrofitcallback;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
@SpringBootApplication
@Configuration
@EnableScheduling
public class BaranidharanApplication {

	public static void main(String[] args) {

		SpringApplication.run(BaranidharanApplication.class, args);


	}

		//@Query("SELECT c.id  FROM RetroFitTestApi AS c GROUP BY c.id ORDER BY c.id DESC")


	@Bean
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder()
				.addInterceptor(chain -> chain.proceed(chain.request()))
				.build();
	}

	@Bean
	public Retrofit RRetrofit(@Qualifier("okHttpClient") OkHttpClient client) {
		return new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl("https://jsonplaceholder.typicode.com")
				.client(client)
				.build();
	}

	@Bean
	public Retrofitcallback retrofitcallback(@Qualifier("RRetrofit") Retrofit retrofit) {
		return retrofit.create(Retrofitcallback.class);
	}






}

