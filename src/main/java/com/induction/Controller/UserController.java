package com.induction.Controller;


import com.induction.Baranidharan.TestDb;
import com.induction.Repository.StudentRepository;
import com.induction.RetrofitClass.Retrofitcallback;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.http.Path;


//import com.induction.response;

import java.util.List;

@EnableKafka
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	public  Retrofitcallback retrofitcallback;

	@Autowired
	private  TestDb testDb;

	private KafkaTemplate<String , String> ktemplate;
	private static final  String topic = "kafka_example";

	public UserController(KafkaTemplate<String, String> ktemplate) {
		this.ktemplate = ktemplate;
	}


	@GetMapping
	public List<TestDb> listAll(Model model) {
		List<TestDb> listStudents = studentRepo.findAll();
		model.addAttribute("listStudents", listStudents);
		return  listStudents;

	}

//kafka module
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message)
	{
		ktemplate.send(topic,message);
		System.out.println(message);
		return "published sucess";
	}
	

	@PostMapping
	public TestDb createEmployee(@RequestBody TestDb employee) {
		return studentRepo.save(employee);
	}


	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable String id) {
		//return testDb.getId(id);

	}

	@GetMapping("/hit")
	public void employee()
	{
		System.out.println(retrofitcallback.getUser("hello"));
	}


	}







