package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalGetVSOrElseOrElseGetMethods {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Alice", 85), new Student("Bob", 55),
				new Student("Charlie", 72), new Student("David", 91), new Student("Eve", 68));

		// Find the top student
		Optional<Student> topStudent = students.stream().reduce((s1, s2) -> s1.getGrade() > s2.getGrade() ? s1 : s2);

		if (topStudent.isPresent()) {
			System.out.println("Top Student from isPresent() : " + topStudent.get());
		} else {
			System.out.println("No students found.");
		}
		
		//Use ifPresent() -> to get the content out of optional, it takes a consumer, you can do whatever you want to do in consumer like print and db activities. 
		topStudent.ifPresentOrElse(
				student -> System.out.println("I am from ifPresentOrElse(, Student: "+ student),
				()-> System.out.println("I am a default message to say no student were present, stream is empty."));
		
		// Here top student is a Student object so, you must provide some default Student obj details in case of empty stream. 
		// Best approach to pass a default value in case of empty stream.
		// orElse()---> directly takes the Student obj that needs to be returned. 
		System.out.println("Student details from OrElse() :" + topStudent.orElse(new Student("No student found", 0.0)));
		
		// Another way would be to use orElseGet(), which takes a supplier inside as argument. 
		//()-> new employee() is returned. 
		System.out.println("Student details from OrElseGet() :" + topStudent.orElseGet(()->new Student("No student found", 0.0)));
		
		
	}

	private static class Student {
		private String name;
		private double grade;

		public Student(String name, double grade) {
			this.name = name;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public double getGrade() {
			return grade;
		}

		@Override
		public String toString() {
			return "Student{" + "name='" + name + '\'' + ", grade=" + grade + '}';
		}
	}
}
