package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users_medicos")
public class UserMedicos {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_seq")
	@Column(name="medicos_id")
	private Integer id;
	
	private String nameOfMedico;
	@Column(name="user_id")
	private Integer user_id;
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public UserMedicos() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameOfMedico() {
		return nameOfMedico;
	}

	public void setNameOfMedico(String nameOfMedico) {
		this.nameOfMedico = nameOfMedico;
	}
	
}
