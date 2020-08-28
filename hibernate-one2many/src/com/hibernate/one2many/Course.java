package com.hibernate.one2many;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "instructor_id", insertable = false, updatable = false)
	private Integer instructor_id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(Integer instructor_id) {
		this.instructor_id = instructor_id;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	// constructor
	public Course () {}
	public Course (String t) {
		super();
		this.title = t;
	}
	
	// method
	public String courseDetail() {
		String title = this.getTitle(), instructorName = this.instructor.extended();
		return instructorName + ' ' + title;
	}
}
