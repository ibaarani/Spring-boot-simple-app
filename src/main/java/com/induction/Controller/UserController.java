package com.induction.Controller;


import com.induction.DataModel.RetroFitTestApi;
import com.induction.Repository.StudentRepository;
import com.induction.Repository.TestApiInterface;
import com.induction.RetrofitClass.Retrofitcallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;


//import com.induction.response;

import java.io.IOException;
import java.util.List;

//@EnableKafka
@RestController
//@RequestMapping
public class UserController {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	public Retrofitcallback retrofitcallback;

	@Autowired
	public TestApiInterface testApiInterface;


//	private KafkaTemplate<String , String> ktemplate;
//	private static final  String topic = "kafka_example";
//
//	public UserController(KafkaTemplate<String, String> ktemplate) {
//		this.ktemplate = ktemplate;
//	}


//	@GetMapping("/users")
//	public List<TestDb> listAll(Model model) {
//		List<TestDb> listStudents = studentRepo.findAll();
//		model.addAttribute("listStudents", listStudents);
//		return  listStudents;
//
//	}

	@GetMapping("/userbase")
	public List<RetroFitTestApi> listAll(Model model2) {
		List<RetroFitTestApi> listStudents = testApiInterface.findAll();
		model2.addAttribute("listStudents", listStudents);
		return listStudents;

	}


	public RetroFitTestApi createEmployee(@RequestBody RetroFitTestApi employee) {
		return testApiInterface.save(employee);
	}

	@GetMapping("/finaltry")
	public RetroFitTestApi getRepos() throws IOException {
		Call<RetroFitTestApi> retrofitCall = retrofitcallback.getUser(5);

		Response<RetroFitTestApi> response = retrofitCall.execute();

		return  response.body();

		}
//kafka module
//	@GetMapping("/publish/{message}")
//	public String post(@PathVariable("message") final String message)
//	{
//		ktemplate.send(topic,message);
//		System.out.println(message);
//		return "published sucess";
//	}
//
//
//	@PostMapping
//	public TestDb createEmployee(@RequestBody TestDb employee) {
//		return studentRepo.save(employee);
//	}

//
//	@GetMapping(value = "/users/{id}")
//	public User getUser(@PathVariable String id) {
//		return ;
//
//	}


		//@GetMapping("/hit1")
//		System.out.println(retrofitcallback.getUser("dem"));
//		public List<RetroFitTestApi> getRepos() throws IOException {
//		return (List<RetroFitTestApi>) retrofitcallback.getUser("hello");
//	}


//		List<TestDb> all() {
//		return studentRepo.findAll();
//	}

//	public List<RetroFitTestApi> getRepos() throws IOException {
//		return (List<RetroFitTestApi>) retrofitcallback.getUser("hello");
		//return retrofitCall;
	}













