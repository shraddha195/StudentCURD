package com.example.StdCurd;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private final StudentService stdservice;
	StudentController(StudentService stdservice){
		this.stdservice=stdservice;
	}
	//display all std
	@GetMapping
	public String Liststd(Model model) {
		model.addAttribute("students", stdservice.getallstd());
		return "Liststd";
	}
	
	//form for add new std
	@GetMapping("/register")
	public String showstdform(Model model) {
		Student std=new Student();
		model.addAttribute("student", std);
		return "registerstd";
	}
	
	@PostMapping("/save")
	public String savestd(@ModelAttribute("student") Student student) {
		stdservice.addstud(student);
		return "redirect:/student";
	}

}
