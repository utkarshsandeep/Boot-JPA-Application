package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="users_medication")
public class UsersMedication {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToOne
	@JoinColumn(name = "id")
	@MapsId
	private User user;
	
	public UsersMedication() {
		
	}
	
	public User getUser() {
		return user;
	}
	public UsersMedication setUser(User user) {
		this.user = user;
		return this;
	}
	public Integer getId() {
		return id;
	}
	public UsersMedication setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public UsersMedication setName(String name) {
		this.name = name;
		return this;
	}
	
	
}
