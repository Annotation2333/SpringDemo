package com.example.spring.repository;


import com.example.spring.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
}
