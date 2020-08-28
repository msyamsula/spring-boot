package com.hibernate.table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "detail_id", insertable = false, updatable = false)
	private Integer detail_id;
	
	// make detail_id foreign key from instructorDetail
	// cascade operation
	@JoinColumn(name = "detail_id")
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private InstructorDetail instructorDetail;
	
	// one to many with course
	@OneToMany(mappedBy = "instructor", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	List<Course> courses;
	
	// constructor
	public Instructor() {
		
	}
	public Instructor(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	// getter and setter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(Integer detail_id) {
		this.detail_id = detail_id;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	// method
	public void addCourse(Course course) {
		if (this.courses == null) {
			this.courses = new ArrayList<>();
		}
		this.courses.add(course);
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", instructorDetail=" + instructorDetail + ", courses=" + courses + "]";
	}
	

}
