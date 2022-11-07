package com.axsos.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "dojos")
public class Dojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "name can't be blank")
	@Size(min = 3, max = 100, message = "name has to be min 3 characters")
	private String name;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd','HH:mm")
	private Date updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninja> ninjas;
	
	// Constructors 
	public Dojo() {
	}

	public Dojo(String name) {
		this.name = name;
	}

	// S&G
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
}
