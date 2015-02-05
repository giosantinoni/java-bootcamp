package com.globant.topic5.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
	
	public Course() {
		students = new ArrayList<Student>();
	}
	
	public Course(Teacher teacher) {
		this.teacher = teacher;
		students = new ArrayList<Student>();
	}

	public Course(int id, Teacher teacher, List<Student> students) {
		this.id = id;
		this.teacher = teacher;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setName(String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}
}
