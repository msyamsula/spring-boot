package com.hibernate.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "detail_id", insertable = false, updatable = false) // little modification for cascade insert
	private Integer detailId;
	
	
	@OneToOne(cascade = CascadeType.ALL) // one to one cascade operation
	@JoinColumn(name = "detail_id") // specify that this table of detail_id is foreign key with referecen to below table;
	private InstructorDetail instructorDetail;
	
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
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	// constructor
	public Instructor() {}
	public Instructor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//method
	public String extended() {
		return getFirstName() + " " + this.getLastName() + " " + this.instructorDetail.getYoutube() + " " + this.instructorDetail.getHobby();
	}
	
}
