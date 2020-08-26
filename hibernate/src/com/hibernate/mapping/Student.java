package com.hibernate.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity tell that this class is mapped to database
// @Table(name="tableName") specify the target map in database
@Entity
@Table(name="student")
public class Student {
	// @Column(name="tableName") annotation map variable id to column "id" in table "student"
	// @Id tell that it is primary key
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auxiliary for handling auto_increment
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// Constructor
	public Student() {} // default consturctor is needed
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String getFullName() {
		return this.getLastName()+", "+this.getFirstName();
	}
	
	
}
