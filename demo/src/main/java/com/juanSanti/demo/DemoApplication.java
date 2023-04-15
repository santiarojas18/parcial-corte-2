package com.juanSanti.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.juanSanti.demo.model.Employee;
import com.juanSanti.demo.service.EmployeeService;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			
			System.out.println("\nDeleting all employees....");
			employeeService.deleteAllEmployees();
			
			System.out.println("Adding employees....\n");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate birth = LocalDate.parse("2003/11/18", formatter);
			employeeService.addEmployee(new Employee("Santiago", "Arevalo", "Salesman", 63000.00, birth));
			
			LocalDate birth2 = LocalDate.parse("1992/06/15", formatter);
			employeeService.addEmployee(new Employee("Jorge Eulises", "Useche", "Salesman", 65000.00, birth2));
			
			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
			
			
		};
	}

}

