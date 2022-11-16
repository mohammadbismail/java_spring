package com.axsos.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.mvc.models.LoginUser;
import com.axsos.mvc.models.Project;
import com.axsos.mvc.models.User;
import com.axsos.mvc.services.AppService;
import com.axsos.mvc.services.UserService;

@Controller
public class MainController {
	@Autowired
	UserService userServ;
	
	@Autowired
	AppService appServ;
	
	@GetMapping("/")
	public String register(HttpSession session, Model model) {
//		if (session.getAttribute("user") != null) {
//			return "redirect:/dashboard";
//		}
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,
			HttpSession session) {

		// go to registration process in services
		userServ.register(user, result);

		if (result.hasErrors()) {
			// if there are errors in filling registration form
			// keep the filled data for registration object
			// again give new login user object to fill
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		} else {
			session.setAttribute("user_id", user.getId());
			return "redirect:/dashboard";
		}
	}
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser loginUser, BindingResult result, Model model,
			HttpSession session) {
		// go to login process
		userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		} else {
			User registeredUser = userServ.findUserByEmail(loginUser.getEmail());
			session.setAttribute("user_id", registeredUser.getId());
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model,HttpSession session) {
		
		Long loggedUser_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.findUserById(loggedUser_id);
		model.addAttribute("loggedUser", loggedUser);
//		List<Project> projectsUserNotTL = appServ.projectsWhereUserIsNotTL(loggedUser.getId());
		List<Project> projectsUserNotMemeberOf = appServ.projectsUserNotMemberOf(loggedUser.getId());
//		List<Project> projectsUserIsTL = appServ.projectsWhereUserIsTL(loggedUser.getId());
		List<Project> projectsUserMemberOf = appServ.projectsUserMemberOf(loggedUser.getId());
//		List<Project> newList = new ArrayList<>(projectsUserIsTL);
//		newList.addAll(projectsUserMemberOf);
		model.addAttribute("projectsNotMember", projectsUserNotMemeberOf);
		model.addAttribute("projectsMemberOrTL", projectsUserMemberOf);
		return "dashboard.jsp";
	}
	@GetMapping("/projects/{projectid}")
	public String showProject(@PathVariable("projectid") Long projectid,HttpSession session, Model model) {
		Long loggedUser_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.findUserById(loggedUser_id);

		model.addAttribute("projectToShow", appServ.findProject(projectid));
		model.addAttribute("loggedUser", loggedUser);
		return "project.jsp";
	}
	
	@GetMapping("/projects/add")
	public String addProjectPage(@ModelAttribute("project") Project project, HttpSession session,Model model) {
		Long loggedUser_id = (Long) session.getAttribute("user_id");
		User loggedUser = userServ.findUserById(loggedUser_id);		
		model.addAttribute("loggedUser", loggedUser);
		return "addProject.jsp";
	}
	
	@PostMapping("/projects/create")
	public String addProject(HttpSession session,@Valid @ModelAttribute("project") Project project,BindingResult result) {
		if (result.hasErrors()) {
			return "addProject.jsp"; 
		}
		Long loggedUser_id = (Long) session.getAttribute("user_id");
		User user = userServ.findUserById(loggedUser_id);	
		appServ.createProject(project,user);
		return "redirect:/dashboard";
	}
	@DeleteMapping("/projects/delete")
	public String deleteProject(@RequestParam("projectid") Long projectid) {
		appServ.deleteProject(projectid);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/userJoinTeam")
	public String jointeam(
							@RequestParam("project_id")  Long projectid,
							@RequestParam("user_id") Long userid) {
		appServ.joinUserOnProject(userid,projectid);
		return "redirect:/dashboard";
	}
	
	@PutMapping("/userLeaveTeam")
	public String leaveTeam(@RequestParam("project_id")  Long projectid,
			@RequestParam("user_id") Long userid) {
			appServ.leaveProject(userid,projectid);
		return "redirect:/dashboard";
	}
	@GetMapping("/projects/edit/{project_id}")
	public String editProjectPage(Model model,@PathVariable("project_id") Long projectid) {
		Project project = appServ.findProject(projectid);

		model.addAttribute("projectToEdit", project);
		return "edit.jsp";
	}
	@PutMapping("/projects/edit/{project_id}")
	public String editProject(@RequestParam("id") Long projid,@Valid @ModelAttribute("projectToEdit") Project projectAfterEdit, BindingResult results)  {
		if (results.hasErrors()) {
			return "edit.jsp";
		}
		else {
			System.out.println(projid);
//			User currentUser = (User) session.getAttribute("user");
//			appServ.updateProject(projectBeforeEdit,projectAfterEdit,teamLead);
			appServ.upd(projectAfterEdit,projid);
			return "redirect:/dashboard";
		}
	}
}
