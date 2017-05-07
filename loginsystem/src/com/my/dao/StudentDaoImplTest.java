package com.my.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.my.entity.Students;


public class StudentDaoImplTest {
	@Test
	public void testAddStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		@SuppressWarnings("deprecation")
		//年份java中是从1900年开始计算到现在的年间隔
		Date date = new Date(2015 - 1900, 6 - 1, 24);
		
		Students student = new Students("S0000001", "张三丰", "男", date, "武当山");
		
		assertEquals(true, studentsDao.addStudent(student));
	}
	
	//测试更新学生数据方法
	@Test
	public void testUpdateStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		@SuppressWarnings("deprecation")
		Date date = new Date(2015 - 1900, 6 - 1, 24);
		
		Students student = new Students("S0000001", "张三丰", "男", date, "武当山");
		
		assertEquals(true, studentsDao.updateStudent(student));
	}
	
	//测试删除学生数据方法
	@Test
	public void testDeleteStudent() {
		StudentsDao studentsDao = new StudentsDaoImpl();
		@SuppressWarnings("deprecation")
		Date date = new Date(2015 - 1900, 6 - 1, 24);
		
		Students student = new Students("S0000001", "张三丰", "男", date, "武当山");
		
		assertEquals(true, studentsDao.deleteStudent(student.getSid()));
	}
	
	@Test
	public void testDeleteStudent1() {
		StudentsDao studentsDao = new StudentsDaoImpl();
	
		Students student = new Students();
		student.setSid("S0000001");
		
		assertEquals(true, studentsDao.deleteStudent(student.getSid()));
	}
	
}
