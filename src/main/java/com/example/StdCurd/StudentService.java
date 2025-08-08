package com.example.StdCurd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private final StudentRepository studrepo;
	StudentService(StudentRepository studrepo){
        this.studrepo=studrepo;
	}
	
	//fetch all student
	public List<Student> getallstd(){
        return studrepo.findAll();		
	}
	//fetch by id
	public Student getbyid(Long id) {
		return studrepo.findById(id).orElse(null);
	}
	//add std
	public void addstud(Student std) {
		studrepo.save(std);
	}
	//update std
	public void updatestd(Student std) {
		studrepo.save(std);
	}
	
	//delete std
	public void deletebyid(Long id) {
		studrepo.deleteById(id);
	}
}
