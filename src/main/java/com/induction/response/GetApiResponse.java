package com.induction.response;

public class GetApiResponse {
 
	
	private long id;
	private String Firstname ;
	private String Lastname;
	
	
	public GetApiResponse(long id, String firstname, String lastname) {
		this.id = id;
		Firstname = firstname;
		Lastname = lastname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	
	
}
