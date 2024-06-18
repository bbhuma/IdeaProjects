package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsProductCatalogAssginment3 {

	/*
	 * 
	1. Filter Students by Passing Grade:
	
	We use the filter method to keep only students with a grade above 70.
	We print their names using map to extract the names and forEach to print each name.
	
	2. Calculate Average Grade:
	
	We use the mapToDouble method to convert the stream of students to a stream of grades.
	We then use average to calculate the average grade and provide a default value of 0.0 if no average is found.
	
	3. Boost Grades:
	
	We use the map method to create a new Student object for each student with their grade increased by 5%.
	We collect the new list of students with boosted grades using collect(Collectors.toList()).
	
	4. Find the Top Student:
	
	We use the reduce method to find the student with the highest grade.
	We print the top student if present.
	
	5. Group Students by Grade Range:
	
	We use the collect method with Collectors.groupingBy to group students into categories based on their grades.
	We define a helper method getGradeRange to categorize the students into grade ranges (A, B, C, D, F).	 
	 */
	
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

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("Alice", 85), new Student("Bob", 55),
				new Student("Charlie", 72), new Student("David", 91), new Student("Eve", 68));

		// 1. Filter Students by Passing Grade
		List<Student> passingStudents = students.stream().filter(s -> s.getGrade() > 70).collect(Collectors.toList());
		System.out.println("Passing Students: " + passingStudents);

		// 1. Print their names
		passingStudents.stream().map(Student::getName).forEach(System.out::println);

		// 2. Calculate Average Grade
		double averageGrade = students.stream().mapToDouble(Student::getGrade).average().orElse(0.0);
		System.out.println("Average Grade: " + averageGrade);

		// 3. Boost Grades
		List<Student> boostedGrades = students.stream().map(s -> new Student(s.getName(), s.getGrade() * 1.05))
				.collect(Collectors.toList());
		System.out.println("Students with Boosted Grades: " + boostedGrades);

		// 4. Find the Top Student
		Optional<Student> topStudent = students.stream().reduce((s1, s2) -> s1.getGrade() > s2.getGrade() ? s1 : s2);
		topStudent.ifPresent(s -> System.out.println("Top Student: " + s));

		// 5. Group Students by Grade Range
		Map<String, List<Student>> studentsByGradeRange = students.stream()
				.collect(Collectors.groupingBy(StreamsProductCatalogAssginment3::getGradeRange));
		System.out.println("Students by Grade Range: " + studentsByGradeRange);
	}

	private static String getGradeRange(Student student) {
		double grade = student.getGrade();
		if (grade >= 90) {
			return "A";
		} else if (grade >= 80) {
			return "B";
		} else if (grade >= 70) {
			return "C";
		} else if (grade >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

}
