package com.axsos.spring.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	public static ArrayList<String> updates = new ArrayList<String>();
	public static Integer totalGold = 0;
	@GetMapping("/")
	public String gold() {
		return "index.jsp";
	}
	@GetMapping("/findgold")
	public String findgold(HttpSession session) {
		Random randMachine = new Random();
		Integer randNum = randMachine.nextInt(10, 20);
		totalGold += randNum;
		String earn;
		String color;
		if (randNum.intValue() > 0) {
			earn = "earned";
			color ="text-success";
		}
		else {
			earn = "lost";
			color = "text-danger";
		}
		String message = String.format("<p class=%s> You have earned a place and %s a %d gold </p>",color,earn,randNum);
		updates.add(message);
		session.setAttribute("gold", totalGold);
		session.setAttribute("updates", updates);
//		System.out.println("Generated gold is " + randNum);
//		System.out.println("Total Gold is "+totalGold);
//		for (String item : updates) {
//			System.out.println(item);
//		}
		return "redirect:/";
	}
	@GetMapping("/quest")
	public String quest(HttpSession session) {
		Random randMachineQuest = new Random();
		Integer randNumQuest = randMachineQuest.nextInt(-50, 50);
		totalGold +=randNumQuest;
		String earn;
		String color;
		if (randNumQuest.intValue() > 0) {
			earn = "earned";
			color ="text-success";
		}
		else {
			earn = "lost";
			color = "text-danger";
		}
		String message = "<p class='"+color+"'>You have earned a place and"+earn+"a"+randNumQuest+"gold</p>";
//		String message = String.format("<p class=%s> You have earned a place and %s a %d gold </p>",color,earn,randNumQuest);
		updates.add(message);
		session.setAttribute("gold", totalGold);
		session.setAttribute("updates", updates);
//		System.out.println("Generated gold is from Quest is " + randNumQuest);
//		System.out.println("Total Gold is "+totalGold);
		return "redirect:/";
	}
}
