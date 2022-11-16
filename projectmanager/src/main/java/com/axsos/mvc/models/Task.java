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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="info is required!")
	@Size(min=3,max=100,message="task must be 3 characters min")
	private String taskinfo;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public Task(
			@NotEmpty(message = "info is required!") @Size(min = 3, max = 100, message = "task must be 3 characters min") String taskinfo,
			Project project, User user) {
		this.taskinfo = taskinfo;
		this.project = project;
		this.user = user;
	}

	public Task() {
	}

	
	public Long getId() {
		return id;
	}

	public String getTaskinfo() {
		return taskinfo;
	}

	public void setTaskinfo(String taskinfo) {
		this.taskinfo = taskinfo;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
