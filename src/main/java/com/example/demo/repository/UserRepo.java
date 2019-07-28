package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {

	Optional<List<User>> findByUname(String uname);
	/*List<User> findByUname(String uname);
	List<User> findByUidGreaterThan(int uid);
	
	@Query("from user where uname=?1 order by uname")
	List<User> findByUnameSorted(String uname);*/

}
