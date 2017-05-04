package com;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.Set;
import org.junit.Test;

public class testmany {

//关联关系的维护由project方来维护；	
  public static void main(String[] args){
	  
  }
  @Test
  public void add(){
	  Project project1=new Project(1001,"项目一");
	  Project project2=new Project(1002,"项目二");
	  Employee employee1=new Employee(1,"女神");
	  Employee employee2=new Employee(2,"男神");
	  project1.getEmployees().add(employee1);
	  project1.getEmployees().add(employee2);
	  project2.getEmployees().add(employee1);
	  
	  	
	  Session  session=HibernateUtil.getsession();
	  Transaction transaction = session.beginTransaction();
	  session.save(project1);
	  session.save(project2);
	  transaction.commit();
	  HibernateUtil.closesession(session);
		  
  }
  @Test
  //查询员工信息
  public  void find(){
	  Session  session=HibernateUtil.getsession();
	  Employee employee=(Employee)session.get(Employee.class, 2);
	  System.out.print(employee);
	  //evict方法清除一级缓存中的制定对象
	  //session.evict(employee);
	  //clear清除一级缓存的所有内容
	  //session.clear();
	  //
			 
	    
  }
}
