package com.axsos.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is required!")
	@Size(min=3,max=100,message="Username must be 3 characters min")
	private String firstname;
	
	@NotEmpty(message="Username is required!")
	@Size(min=3,max=100,message="Username must be 3 characters min")
	private String lastname;
	
	@NotEmpty(message="email can't be blank!")
	@Email(message="please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date updatedAt;
	
	// Relation
	@OneToMany(mappedBy="teamLead",fetch=FetchType.LAZY)
	private List<Project> projectsCreated;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_projects",
			   joinColumns = @JoinColumn(name = "user_id"),
			   inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projects;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private List<Task> tasks;
	 
	public User() {
		}

	public User(
			@NotEmpty(message = "Username is required!") @Size(min = 3, max = 100, message = "Username must be 3 characters min") String firstname,
			@NotEmpty(message = "Username is required!") @Size(min = 3, max = 100, message = "Username must be 3 characters min") String lastname,
			@NotEmpty(message = "email can't be blank!") @Email(message = "please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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

	public List<Project> getProjectsCreated() {
		return projectsCreated;
	}

	public void setProjectsCreated(List<Project> projectsCreated) {
		this.projectsCreated = projectsCreated;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	 
	
}
