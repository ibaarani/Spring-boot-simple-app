package com.induction.Baranidharan;


import org.hibernate.dialect.SybaseAnywhereDialect;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.ManyToOne;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

@SpringBootApplication
//@EnableScheduling

public class BaranidharanApplication {

	URL url;

	{
		try {
			url = new URL("https://restcountries.com/v3.1/all");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	StudentRepository studentRepository;
	testdb dr = new testdb();

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
	@Scheduled(cron = "*/1 * * * * *")
	public void run() {
		//System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		//int a = dr.getId();
		//String name = dr.getName();
		//String ab = dr.getDate();
		//String mail = dr.getEmail();
		//System.out.println(mail+name);
		try{
			//make connection
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setRequestMethod("GET");
			// set the content type
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
				var newstr = ang.substring(1, ang.length()-1);
				JSONObject obj = new JSONObject(newstr);
				System.out.println("Employee ID: "+obj.getJSONObject("name").getString("official"));
				//System.out.println(l);
				dr.setId(1);
				dr.setEmail(obj.getJSONObject("name").getString("official"));
				//dr.setDate("hekko");
				dr.setName("sign in");
				studentRepository.save(dr);
			}
			br.close();
		} catch (Exception e){
			System.out.println("Error occured");
			System.out.println(e.toString());
		}
		}

	}

