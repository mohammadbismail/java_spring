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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="title can't be blank")
	@Size(min=3,max=100,message="title has to be min 3 characters")
	private String title;
	
	@NotNull(message="title can't be blank")
	@Size(min=3,max=100,message="description has to be min 3 characters")
	private String description;
	
	@NotNull(message="Date must not be null")
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date updatedAt;
	
	// relations
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teamLead_id")
	private User teamLead;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_projects",
			   joinColumns = @JoinColumn(name = "project_id"),
			   inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	// one project has many tasks 
	@OneToMany(mappedBy="project", fetch=FetchType.LAZY)
	private List<Task> tasks;

	// constructors
	public Project() {
	}



	public void setId(Long id) {
		this.id = id;
	}



	// G&S
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public User getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	

	
	
 }	
