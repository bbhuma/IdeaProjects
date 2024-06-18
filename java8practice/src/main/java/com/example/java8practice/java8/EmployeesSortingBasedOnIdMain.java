package com.example.java8practice.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeesSortingBasedOnIdMain {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("bala", 1));
		employees.add(new Employee("niha", 2));
		employees.add(new Employee("shiva", 3));
		employees.add(new Employee("ramu", 4));

		// Comparator using the compare method and ternary operator
		Comparator<Employee> comp = (e1, e2) -> (e1.getId() < e2.getId()) ? -1 : (e1.getId() > e2.getId()) ? 1 : 0;

		// Sort the list using the custom comparator
		employees.sort(comp);

		// Print the sorted list
		employees.forEach(System.out::println);
	}
}

class Employee123 {
	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", id=" + id + '}';
	}
}