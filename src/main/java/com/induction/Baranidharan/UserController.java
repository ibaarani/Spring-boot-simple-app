package com.induction.Baranidharan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//import com.induction.response;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private StudentRepository studentRepo;

	@GetMapping
	public List<testdb> listAll(Model model) {
		List<testdb> listStudents = studentRepo.findAll();
		model.addAttribute("listStudents", listStudents);
		return  listStudents;

	}

	@PostMapping
	public testdb createEmployee( @RequestBody testdb employee) {
		return studentRepo.save(employee);
	}




	}







