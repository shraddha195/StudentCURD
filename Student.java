package com.example.StdCurd;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentCURD")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column
	private String Name;
	
	@Column
	private int age;
	
	@Column
	private String Address;
	
	
	public Student() {} // Make this public

	public Student(Long id, String name, int age, String address) {
		this.id = id;
		this.Name = name;
		this.age = age;
		this.Address = address;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}

	
	@Override
	public String toString() {
		return "Student[id="+id+", Name="+Name+", Age="+age+", Address="+Address+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, Name, age, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(Name, other.Name) && age == other.age
				&& Objects.equals(id, other.id);
	}
	

}



