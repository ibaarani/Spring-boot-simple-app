package com.induction.Baranidharan;


import com.induction.DataModel.RetroFitTestApi;
import com.induction.Repository.StudentRepository;
import com.induction.RetrofitClass.Retrofitcallback;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
@EnableScheduling
public class BaranidharanApplication {
	public static  int a = 0;
	URL url;
	{
		try {
			url = new URL("https://jsonplaceholder.typicode.com/todos/1");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	//@Autowired
	StudentRepository studentRepository;
	TestDb dr = new TestDb();
	RetroFitTestApi r = new RetroFitTestApi();

	public static void main(String[] args) {
		SpringApplication.run(BaranidharanApplication.class, args);


	}
	/*
	// post data using the shedulers
	@Scheduled(cron = "*10 * * * * *")
	public void run() {

		//testdb dr = new testdb();
		int a = 100;
		//String date = Calendar.getInstance().getTime();
		dr.setId(++a);
		dr.setName("baani");
		dr.setEmail("hey google");
		dr.setDate();
		studentRepository.save(dr);

	}*/

	//get data from schedulers
	@Scheduled(cron = "*/10 * * * * *")
	public void run() {
		//System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		//int a = dr.getId();
		//String name = dr.getName();
		//String ab = dr.getDate();
		//String mail = dr.getEmail();
		//System.out.println(mail+name);
		try{

			a++;
			url = new URL("https://jsonplaceholder.typicode.com/todos/"+ a);
			//make connection
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setRequestMethod("GET");
			//set the content type
			urlc.setRequestProperty("Content-Type", "application/json");
			urlc.setRequestProperty("X-JokesOne-Api-Secret", "YOUR API KEY HERE");
			System.out.println("Connect to: " + url.toString());
			urlc.setAllowUserInteraction(false);
			urlc.connect();

			//get result
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			String l = null;
			while ((l=br.readLine())!=null) {
				//dr.setId(2);
				//dr.setEmail(l);
				//studentRepository.save(dr);
				//JSONObject obj = new JSONObject(l);

				//System.out.println("Employee ID: "+obj.getJSONObject("contents").getJSONArray("jokes").getString(1));
				var ang = l;
				// var newstr = ang.substring(1, ang.length()-1);
				JSONObject obj = new JSONObject(ang);
				System.out.print(obj);
				//System.out.println("Employee ID: "+obj.getJSONArray("userid").getString(1));





				//datasave

				//r.setId();
				//r.setTitle();
				//r.setUserid();
				//r.setCompleted();
				//studentRepository.save(r);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error occured");
			System.out.println(e.toString());
		}
		}

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
				.baseUrl("https://jsonplaceholder.typicode.com/todos/")
				.client(client)
				.build();
	}

	@Bean
	public Retrofitcallback retrofitcallback(@Qualifier("RRetrofit") Retrofit retrofit) {
		return retrofit.create(Retrofitcallback.class);
	}






}

