package com.example.java8practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Create the Employee class with an employeeNumber field.
Create a list of Employee objects.
Sort the list using the Comparator with the Stream API or Collections.sort()*/

/*The sort method is called on the list with a custom comparator to sort the employees by their employee numbers. 
The comparator is implemented using a lambda expression with Integer.compare.*/

public class FindingAnEmployeeByName {

		public static void main(String[] args) {
			List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee("bala", 1));
	        employees.add(new Employee("niha", 2));
	        employees.add(new Employee("shiva", 3));
	        employees.add(new Employee("ramu", 4));
	        
	     // Sort employees by employeeNumber using a custom comparator
	       List<Employee> employees2 = employees;
		employees2.sort((e1,e2)-> Integer.compare(e1.getId(), e2.getId()));
	       
	     // Print all the employee objects using forEach.
	       employees.forEach(System.out::println);
	       

	}

}


