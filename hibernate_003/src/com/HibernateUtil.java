package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private  static SessionFactory sessionfactory;
	private static Session session;
	
	static{
	Configuration config = new Configuration().configure(); // 创建配置对象；
	@SuppressWarnings("deprecation")
	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
			.applySettings(config.getProperties()).buildServiceRegistry();// 创建服务对象；
	// 创建会话工厂对象；
			sessionfactory = config.buildSessionFactory(serviceRegistry);
	}
	public static SessionFactory getsessionfactory(){
		return sessionfactory;
	}
	public static Session getsession(){
		
		// 会话对象;
		session = sessionfactory.openSession();
		// 开启事务
	
		return session;	
	}
	
	public static void closesession(Session session){
		
		if(session!=null)
			session.close();// 关闭会话；
			sessionfactory.close();// 关闭会话工厂；
		}
	}


