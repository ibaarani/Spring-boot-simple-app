package com.induction.Baranidharan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.ManyToOne;
import java.util.Calendar;

@SpringBootApplication
@EnableScheduling

public class BaranidharanApplication {

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
		String name = dr.getName();
		//String ab = dr.getDate();
		String mail = dr.getEmail();
		System.out.println(mail+name);
	}

}

