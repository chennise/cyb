package com.my.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.my.entity.Students;
import com.my.util.HibernateSessionFactory;
/**
 * 操作学生的实现类
 * 实现学生的增删改查
 * @author yun
 *
 */
public class StudentsDaoImpl implements StudentsDao {

	private Session session;
	
	//添加一条记录到学生表中去
	@Override
	public boolean addStudent(Students student) {
		
		String sid = getNewSid();
		if(sid == null) {
			return false;
		}
		student.setSid(sid);
		
		Transaction transaction = null;
		try {
			this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

			transaction = session.getTransaction();
			transaction.begin();
			
			session.save(student);
			
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.out.println("插入学生数据到数据库失败");
			e.printStackTrace();
			if(transaction != null){
				transaction = null;
			}
			return false;
		}finally{
			if(transaction != null){
				transaction = null;
			}
		}	
	}
	
	//更新一条学生记录
	@Override
	public boolean updateStudent(Students student) {
		// TODO Auto-generated method stub
		this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(student);
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("更新学生数据到数据库失败");
			e.printStackTrace();
			if(transaction != null){
				transaction = null;
			}
			return false;
		}
		if(transaction != null){
			transaction = null;
		}
		return true;	
	}
	
	//从students表中通过sid删除一条记录
	@Override
	public boolean deleteStudent(String sid) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
		this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		
		//Students student = new Students();  //my	
		
			transaction = session.getTransaction();
			transaction.begin();
			//get方法是根据id获取到一条记录,注意必须开启了事务才能用
			Students student = (Students) this.session.get(Students.class, sid);
			
			session.delete(student);
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("从数据库删除学生数据失败");
			e.printStackTrace();
			if(transaction != null){
				transaction = null;
			}
			return false;
		}
		if(transaction != null){
			transaction = null;
		}
		return true;	
	}
	
	//查询到Students表中所有记录
	@Override
	public List<Students> queryStudents() {
		// TODO Auto-generated method stub
		this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		 Transaction tx = null;
		 List<Students> list = null;
			String hql = "";
			try {
				
				//tx = session.beginTransaction();
			
				//在这里注意hql语句中查询对象不是表而是具体的映射的实体类
				tx = this.session.getTransaction();
				tx.begin();
				hql = "from Students ";
				Query query = this.session.createQuery(hql);	
				list = query.list();
				
				tx.commit();
				if(list !=null && list.size() > 0)	{
					return list;
				} else {
					return null;
				}				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				if(tx != null) {
					tx = null;	
				}	
			}
			
		
	}
	
	//从students表中获取到一条记录
	@Override
	public Students getOneStudent(String sid) {
		Transaction tx = null;
		Students student = null;
		try {
			this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = this.session.getTransaction();
			tx.begin();
			//通过主键获取到一条记录
			student = (Students) this.session.get(Students.class, sid);
				
			tx.commit();
			return student;				
		} catch (Exception e) {
			e.printStackTrace();
			return student;
		}finally{
			if(tx != null) {
				tx = null;	
			}	
		}
	}
	
	
	//获取sid的值格式为Sxxxxxxx
	private String getNewSid() {	
		 Transaction tx = null;
			String hql = "";
			String sid = null;
			try {
				this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
				//在这里注意hql语句中查询对象不是表而是具体的映射的实体类
				tx = this.session.getTransaction();
				tx.begin();
				hql = "select max(sid) from Students";
				Query query = this.session.createQuery(hql);	
				//该方法为获取到一个结果
				sid = (String) query.uniqueResult();
				if(sid == null || "".equals(sid)) {
					sid = "S0000001";
				} else {
					String tmp = sid.substring(1);//从序号1开始取字符串
					int index = Integer.parseInt(tmp)+1;
					tmp = String.valueOf(index);
					int len = tmp.length();
					for(int i = len; i< 7; i++) {
						tmp = '0' + tmp; 
					}
					sid = 'S' + tmp;
				}
					
				tx.commit();
				return sid;				
			} catch (Exception e) {
				e.printStackTrace();
				return sid;
			}finally{
				if(tx != null) {
					tx = null;	
				}	
			}
	}
}
