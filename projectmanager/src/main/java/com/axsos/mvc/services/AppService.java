package com.axsos.mvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.mvc.models.Project;
import com.axsos.mvc.models.User;
import com.axsos.mvc.repositories.ProjectRepository;
import com.axsos.mvc.repositories.TaskRepository;
import com.axsos.mvc.repositories.UserRepository;

@Service
public class AppService {
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	TaskRepository taskRepo;

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userServ;
	
	public List<Project> findAll(){
		return projectRepo.findAll();
	}
	public List<Project> projectsWhereUserIsNotTL(Long userid){
		return projectRepo.projectsWhereUserIsNotTL(userid);
	}
	
	public List<Project> projectsWhereUserIsTL(Long userid){
		return projectRepo.allProjectWhereUserIsTL(userid);
	}
	
	public List<Project> projectsUserMemberOf(Long userid){
		User user = userServ.findUserById(userid);
		return projectRepo.findByusersContains(user);
	}
	
	public List<Project> projectsUserNotMemberOf(Long userid){
		User user = userServ.findUserById(userid);
		return projectRepo.findByusersNotContains(user);
	}
	public Project findProject(Long id) {
		Optional<Project> projectToFind = projectRepo.findById(id);
		if (projectToFind.isPresent()) {
			return projectToFind.get();
		}
		else {
			return null;
		}
	}
	public void deleteProject(Long projectid) {

		projectRepo.deleteById(projectid);
	}
	
	public Project createProject(Project project,User user) {
		// it works without adding user to project users manually
		ArrayList<User> users = new ArrayList<User>();
		users.add(user);
		project.setUsers(users);
		return projectRepo.save(project);
	}
	public void joinUserOnProject(Long userid, Long projectid) {
		User user = userServ.findUserById(userid);
		Project project = this.findProject(projectid);
		List<User> projectUsers = project.getUsers();
		projectUsers.add(user);
		project.setUsers(projectUsers);
		projectRepo.save(project);
	}
	
	public void leaveProject(Long userid,Long projectid) {
		User user = userServ.findUserById(userid);
		Project project = this.findProject(projectid);
		List<User> projectUsers = project.getUsers();
		projectUsers.remove(user);
		project.setUsers(projectUsers);
		projectRepo.save(project);
		
	}
	public Project updateProject(Project project,User user) {
//		project.setTeamLead(user);
		
		return projectRepo.save(project);
		
	}
	public Project upd(Project project,Long id) {
//		project.setTeamLead(user);
//		project.setId(id);
		return projectRepo.save(project);
		
	}
	
 }
