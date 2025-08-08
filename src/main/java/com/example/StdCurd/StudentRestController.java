package com.example.StdCurd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:5500") //replace with your fronten URL
public class StudentRestController {

	@Autowired
	private final StudentService stdservice;
	StudentRestController(StudentService stdservice){
		this.stdservice=stdservice;
	}
	
	//display all list
	@GetMapping
	public List<Student> liststd(){
		return stdservice.getallstd();
	}
	
	//display by id
	@GetMapping("/{id}")
	public Student stdbyid(@PathVariable("id") Long id) {
		Student std=stdservice.getbyid(id);
		if(std!=null) {
			System.out.println("Student "+std);
			return std;
		}
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found");
		
	}
	
	//save 
	@PostMapping("/register")
	public Student savestd(@RequestBody Student student) {
		stdservice.addstud(student);
		return student;
	}
	
	//updatestd
	@PutMapping("/update/{id}")
	public Student updatestd(@PathVariable("id")Long id,@RequestBody Student std) {
		Student existstd=stdservice.getbyid(id);
		if(existstd!=null) {
		    existstd.setName(std.getName());
			existstd.setAge(std.getAge());
			existstd.setAddress(std.getAddress());
			stdservice.updatestd(existstd);
			return existstd;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
	}
	
	//deletestd
	@DeleteMapping("/delete/{id}")
	public String deletestd(@PathVariable("id") Long id) {
		stdservice.deletebyid(id);
		return id+" Std successfully deleted!";
	}
}
