package com.my.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.my.entity.Users;
import com.my.util.HibernateSessionFactory;
/**
 * 用户逻辑实现类
 * @author yun
 *
 */
public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean usersLogin(Users user) {
		// TODO Auto-generated method stub
		 Transaction tx = null;
		String hql = "";
		try {
			
			SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			//session.clear();
     		//tx = session.beginTransaction();		
			//在这里注意hql语句中查询对象不是表而是具体的映射的实体类
			tx = session.getTransaction();
			tx.begin();
			hql = "from  Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());		
			List list = query.list();
			
			tx.commit();
			
			if(list.size() > 0)	{
				return true;
			} else {
				return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		
		}finally{
			if(tx != null) {
				tx = null;	
			}	
		}
		
		
	}

}
