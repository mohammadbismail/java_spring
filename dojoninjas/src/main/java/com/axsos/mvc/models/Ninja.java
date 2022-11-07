package com.axsos.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="firstname can't be blank")
	@Size(min=3,max=100,message="firstname has to be min 3 characters")
	private String firstName;
	
	@NotNull(message="lastname can't be blank")
	@Size(min=3,max=100,message="lastname has to be min 3 characters")
	private String lastName;
	
	@NotNull(message="Age can't be blank")
	@Min(value=20, message="age must be +20")
	private Integer age;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dojo_id")
	private Dojo dojo;

	// Constructors 
	public Ninja() {
	}

	public Ninja(
			String firstName,String lastName,Integer age,Dojo dojo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
	}
	// G&S

	public Long getId() {
		return id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	
	
	
}
