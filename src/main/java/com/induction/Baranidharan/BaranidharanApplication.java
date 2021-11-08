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

	public static void main(String[] args) {
		SpringApplication.run(BaranidharanApplication.class, args);


	}
	@Scheduled(fixedDelay = 10000)
	public void run() {

		testdb dr = new testdb();
		int a = 100;
		dr.setId(++a);
		dr.setName("baani");
		dr.setEmail("hey google");

		studentRepository.save(dr);

	}

}

