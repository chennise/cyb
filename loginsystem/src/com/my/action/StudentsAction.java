package com.my.action;

import java.util.List;

import com.my.dao.StudentsDao;
import com.my.dao.StudentsDaoImpl;
import com.my.entity.Students;
import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	private static final long serialVersionUID = 3887649778992566221L;
	private Students student = new Students();
	
	public String addStudent() {
		
		StudentsDao studentsdao = new StudentsDaoImpl();
		
		if(studentsdao.addStudent(student)) {
			return "add_success";
		}else {
			return "add_failure";
		}
	}
	

	public String queryStudents() {
		StudentsDao studentsdao = new StudentsDaoImpl();
		List<Students> studentList =  studentsdao.queryStudents();
		if(studentList != null) {
			this.httpSession.setAttribute("students_list", studentList);
			return "queryStudents_success";
		}else {
			return "queryStudents_failure";
		}
	}
	
	public String deleteStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		String sid = (String) this.request.getParameter("sid");
		
		if(sid == null) {
			return "deleteStudent_failure";
		}
		
		if(studentsDao.deleteStudent(sid)) {
			return "deleteStudent_success";
		}else {
			return "deleteStudent_failure";
		}
	}
	
	
	public String modifyStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		String sid = this.request.getParameter("sid");
		Students student = studentsDao.getOneStudent(sid);
		this.httpSession.setAttribute("modify_students", student);
		return "goto_modify";
	}
	
	
	public String updateStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		if(studentsDao.updateStudent(student)) {
			return "update_success";
		} else {
			return "update_failure";
		}
	}
	
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return student;
	} 

	
}
