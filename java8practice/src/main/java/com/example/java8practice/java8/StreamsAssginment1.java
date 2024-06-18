package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsAssginment1 {

	/*
	 * 1. Filter Employees by Department: Filter the employees who belong to the
	 * "Engineering" department. Print their names. Calculate Total Salary:
	 * 
	 * 2. Calculate the total salary of all employees using reduce. Increase Salary:
	 * 
	 * 3. Increase the salary of each employee by 10% using map. Collect the updated
	 * employees into a new list and print it. Get Highest Salary:
	 * 
	 * 4. Find the employee with the highest salary using reduce. Group Employees by
	 * Department:
	 * 
	 * 5. Group the employees by their department using collect and
	 * Collectors.groupingBy. Print the result.
	 */
	private static class Employee {
		private String name;
		private String department;
		private double salary;

		public Employee(String name, String department, double salary) {
			this.name = name;
			this.department = department;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public String getDepartment() {
			return department;
		}

		public double getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return "Employee{" + "name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary
					+ '}';
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Alice", "Engineering", 80000),
				new Employee("Bob", "HR", 50000), new Employee("Charlie", "Engineering", 90000),
				new Employee("David", "Sales", 70000), new Employee("Eve", "Engineering", 85000));

		// 1. Filter Employees by Department
		List<Employee> engineeringEmployees = employees.stream().filter(e -> "Engineering".equals(e.getDepartment()))
				.collect(Collectors.toList());
		System.out.println("Engineering Employees: " + engineeringEmployees);

		// 2. Calculate Total Salary
		double totalSalary = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
		System.out.println("Total Salary: " + totalSalary);

		// 3. Increase Salary
		List<Employee> increasedSalaries = employees.stream()
				.map(e -> new Employee(e.getName(), e.getDepartment(), e.getSalary() * 1.10))
				.collect(Collectors.toList());
		System.out.println("Employees with Increased Salaries: " + increasedSalaries);

		// 4. Get Highest Salary
		Optional<Employee> highestSalaryEmployee = employees.stream()
				.reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		highestSalaryEmployee.ifPresent(e -> System.out.println("Highest Salary Employee: " + e));

		// 5. Group Employees by Department
		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("Employees by Department: " + employeesByDepartment);
	}

}
