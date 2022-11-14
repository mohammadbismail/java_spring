package com.axsos.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.mvc.servicies.appService;

@RestController
public class APIController {
	@Autowired
	appService  appServ;

	@GetMapping("/api/q1")
	public List<Object[]> q1() {
		List<Object[]> all = appServ.q1();
		return all;
}
	@GetMapping("/api/q2")
	public List<Object[]> q2() {
		List<Object[]> all = appServ.q2();
		return all;
}
	@GetMapping("/api/q3")
	public List<Object[]> q3() {
		List<Object[]> all = appServ.q3();
		return all;
}
}
