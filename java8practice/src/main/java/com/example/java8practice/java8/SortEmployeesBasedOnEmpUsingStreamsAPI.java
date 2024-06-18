package com.example.java8practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Create the Employee class with an employeeNumber field.
Create a list of Employee objects.
Sort the list using the Comparator with the Stream API or Collections.sort()*/
public class SortEmployeesBasedOnEmpUsingStreamsAPI {

		public static void main(String[] args) {
			List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee("bala", 1));
	        employees.add(new Employee("niha", 2));
	        employees.add(new Employee("shiva", 3));
	        employees.add(new Employee("ramu", 4));
	        
	        //One line code to sort a List of employees and collect thm into a list, then forEach to print all of them. 
	        employees.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

	}

}


