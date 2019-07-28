package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.model.UserMedicos;
import com.example.demo.model.UsersMedication;
import com.example.demo.repository.UsersMedicationRepo;

@RestController
@RequestMapping("/rest/usersmedication")
public class UserMedicationController {
	
	@Autowired
	private UsersMedicationRepo repo;
	
	@GetMapping(value="/all")
	public List<UsersMedication> getUsersMedication(){
		return repo.findAll();
		
	}
	
	@GetMapping(value="/update/{uname}")
	public List<UsersMedication> update(@PathVariable String uname){
		UsersMedication uC = new UsersMedication();
		//uC.setId(1); // <---
		//int id = uC.getId();
		
		UserMedicos um = new UserMedicos();
		um.setNameOfMedico("Crocin");
		
		UserMedicos um2 = new UserMedicos();
		um2.setNameOfMedico("Vicks Action 500");
		
		User u = new User();
		u.setUname(uname)
		.setUsersmedicos(Arrays.asList(um,um2));
			//.setUid(id);
		
		
		uC.setName("D-Cold")
			.setUser(u);
		
		repo.save(uC);
		return repo.findAll();
	}

}
