package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UsersMedication;

public interface UsersMedicationRepo extends JpaRepository<UsersMedication,Integer> {

}
