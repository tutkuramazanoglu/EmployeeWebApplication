package com.cestar.model;

public class Employee {

	
	private int id ;
	
	private String name ;
	
	private String city ;
	
	private String contact ;
	
	private String email ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(int id, String name, String city, String contact, String email) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.contact = contact;
		this.email = email;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + ", contact=" + contact + ", email=" + email
				+ "]";
	}
	
	
}
