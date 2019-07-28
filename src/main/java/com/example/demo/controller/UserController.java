package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	UserRepo repo;

	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	
	@PostMapping(path="/user",consumes= {"application/json"})   //,produces= {"application/xml"})
	public User addUser(@RequestBody User u) {
		repo.save(u);
		return u;
	}
	
	@DeleteMapping("/user/{uid}")
	public String deleteuser(@PathVariable int uid) {
		User u = repo.getOne(uid);
		repo.delete(u);
		return "Deleted";
	}
	
	
	@PutMapping("/user")
	public User saveOrUpdateUser(@RequestBody User u) {
		repo.save(u);
		return u;
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		//User user = repo.findById(uid).orElse(new User());
		
		/*System.out.println(repo.findByUname("Tushar"));
		System.out.println(repo.findByUidGreaterThan(101));
		System.out.println(repo.findByUnameSorted(""));
		mv.addObject(user);*/
		return repo.findAll();
	}
	
	@GetMapping("/user/{uname}")
	public List<User> getUser(@PathVariable String uname){
		Optional<List<User>> list =  repo.findByUname(uname);
		
		List<User> users = list
				//.orElseThrow(() -> new RuntimeException("NO users found..!!"))
				.orElse(new ArrayList<>());
		
		return users;
	}
	
	
	@RequestMapping("/user/{uid}")
	public Optional<User> getUser(@PathVariable("uid") int uid) {
	
		
		return repo.findById(uid);
	}
	
}
