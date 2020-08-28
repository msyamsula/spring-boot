package com.hibernate.one2one_bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="youtube")
	private String youtube;
	
	@Column(name="hobby")
	private String hobby;
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "instructorDetail") // if you don't want to cascade the operation delete pick below cascade
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "instructorDetail") // exclude remove cascade operation
	private Instructor instructor;
	
	// getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	// constructor
	public InstructorDetail() {}
	public InstructorDetail(String youtube, String hobby) {
		super();
		this.youtube = youtube;
		this.hobby = hobby;
	}
	
	// method
	public String detailExtended() {
		return this.getYoutube() + ' ' + this.getHobby() + ' ' + this.instructor.getFirstName() + ' ' + this.instructor.getLastName();
	}
	
}
