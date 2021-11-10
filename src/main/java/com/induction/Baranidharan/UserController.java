package com.induction.Baranidharan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//import com.induction.response;

import java.util.List;

@EnableKafka
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private StudentRepository studentRepo;
	private KafkaTemplate<String , String> ktemplate;
	private static final  String topic = "kafka_example";

	public UserController(KafkaTemplate<String, String> ktemplate) {
		this.ktemplate = ktemplate;
	}


	@GetMapping
	public List<testdb> listAll(Model model) {
		List<testdb> listStudents = studentRepo.findAll();
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
	public testdb createEmployee( @RequestBody testdb employee) {
		return studentRepo.save(employee);
	}




	}







