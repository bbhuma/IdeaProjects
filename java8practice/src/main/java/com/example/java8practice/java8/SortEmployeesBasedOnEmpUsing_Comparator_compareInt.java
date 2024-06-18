package com.example.java8practice.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SortEmployeesBasedOnEmpUsing_Comparator_compareInt {

    public static void main(String[] args) {
        List<Employee1> employees = new ArrayList<>();
        employees.add(new Employee1("Bala", 3, 70000));
        employees.add(new Employee1("Niha", 1, 80000));
        employees.add(new Employee1("Shiva", 2, 75000));
        employees.add(new Employee1("Ramu", 4, 90000));

        // Find employee by name, return Optional, meaning return null 
         Optional<Employee1> foundEmployee = employees.stream()
                .filter(employee -> "Shiva".equals(employee.getName()))
                .findFirst();

        // Print found employee
        System.out.println("Found Employee:");
        foundEmployee.ifPresent(System.out::println);
    }
}

 class Employee1 {
    private String name;
    private int employeeNumber;
    private double salary;

    public Employee1(String name, int employeeNumber, double salary) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", salary=" + salary +
                '}';
    }
}

