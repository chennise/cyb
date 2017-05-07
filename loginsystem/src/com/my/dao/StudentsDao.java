package com.my.dao;

import java.util.List;

import com.my.entity.Students;

public interface StudentsDao {
	public boolean addStudent(Students student);
	public boolean updateStudent(Students student);
	public boolean deleteStudent(String sid);
	public List<Students> queryStudents();
	public Students getOneStudent(String sid);
}
