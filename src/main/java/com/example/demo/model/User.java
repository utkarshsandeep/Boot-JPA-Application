package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_seq")
	private int uid;
	private String uname;
	@OneToOne(mappedBy = "user")
	private UsersMedication usersmedication;
	
	//@NaturalId
	//private Integer mid;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="user_id")
	private List<UserMedicos> usersmedicos = new ArrayList<>();
	
	public List<UserMedicos> getUsersmedicos() {
		return usersmedicos;
	}
	public void setUsersmedicos(List<UserMedicos> usersmedicos) {
		this.usersmedicos = usersmedicos;
	}
	public int getUid() {
		return uid;
	}
	public User setUid(int uid) {
		this.uid = uid;
		return this;
	}
	public String getUname() {
		return uname;
	}
	public User setUname(String uname) {
		this.uname = uname;
		return this;
	}
	@Override
	public String toString() {
		return "User id: " + uid + ", name: " + uname;
	}
	

}
