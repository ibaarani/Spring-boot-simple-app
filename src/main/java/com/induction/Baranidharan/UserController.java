package com.induction.Baranidharan;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.induction.response;
import com.induction.response.GetApiResponse;
@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public GetApiResponse getUsers()
	{
		GetApiResponse  getApiResponse = new GetApiResponse(1,"barani","dharan");
		return getApiResponse;
	}
	@PostMapping
	public String postUsers()
	{
		return "post reflected";
	}
	


}
