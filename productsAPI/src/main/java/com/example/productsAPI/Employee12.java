package com.example.productsAPI;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees12")
 class Employee12 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    ////Try to use @JsonProperty to properly match the RequestBody to Entity Fields.
    @Column(name = "first_name", nullable = false)
    @JsonProperty("firstName") 
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email", nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    private String password;

    @Column(name = "age", nullable = false)
    @JsonProperty("age")
    private int age;

    @Column(name = "dob", nullable = false)
    @JsonProperty("dob")
    private String dob;

    @Column(name = "gender", nullable = false)
    @JsonProperty("gender")
    private String gender;

    @Column(name = "department", nullable = false)
    @JsonProperty("department")
    private String department;

    @Column(name = "resume", nullable = false)
    @JsonProperty("resume")
    private String resume;

    @Column(name = "bio", nullable = false)
    @JsonProperty("bio")
    private String bio;

    @Column(name = "terms", nullable = false)
    @JsonProperty("terms")
    private boolean terms;

	public Employee12(String firstName, String lastName, String email, String password, int age, String dob,
			String gender, String department, String resume, String bio, boolean terms) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.department = department;
		this.resume = resume;
		this.bio = bio;
		this.terms = terms;
	}


	public Employee12() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
