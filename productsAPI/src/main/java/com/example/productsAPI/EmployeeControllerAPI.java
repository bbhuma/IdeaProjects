package com.example.productsAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerAPI {
	@Autowired
	private  EmployeeRepository employeeRepository;

	

	/*
	 * @PostMapping public ResponseEntity<Employee123>
	 * addEmployee(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName,
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("age") Integer age,
	 * 
	 * @RequestParam("dob") LocalDate dob,
	 * 
	 * @RequestParam("gender") String gender,
	 * 
	 * @RequestParam("department") String department,
	 * 
	 * @RequestParam("resume") String resume,
	 * 
	 * @RequestParam("bio") String bio,
	 * 
	 * @RequestParam("terms") boolean terms) { // Create Employee object and save it
	 * Employee123 employee = new Employee123(firstName, lastName, email, password,
	 * age, dob, gender, department, resume, bio, terms); // Handle resume file
	 * processing as needed // employee.setResume(...);
	 * 
	 * Employee123 savedEmployee = employeeRepository.save(employee); return new
	 * ResponseEntity<Employee123>(savedEmployee, HttpStatus.CREATED); }
	 */
	@RestController
	@RequestMapping("/api/employees")
	@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
	public class EmployeeController {

		@Autowired
		private EmployeeRepository employeeRepository;
		
		@CrossOrigin
		@PostMapping
		public ResponseEntity<Employee12> addEmployee(@RequestBody Employee12 employee) {
			try {
				Employee12 savedEmployee = employeeRepository.save(employee);
				return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}
interface EmployeeRepository extends JpaRepository<Employee12, Long> {
    // Define custom queries or methods if needed
}
