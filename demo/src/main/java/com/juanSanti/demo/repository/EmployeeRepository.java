package com.juanSanti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanSanti.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
