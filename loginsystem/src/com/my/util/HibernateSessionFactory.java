package com.my.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * 
 * 该工具类主要是用于获取hibernate框架的session工厂
 * @author yun
 *
 */
public class HibernateSessionFactory {
	//private Session session;
	private  static SessionFactory sessionFactory;
	
	//私有化构造方法
	private HibernateSessionFactory() {
		
	}

	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null) {
			//读取hibernate.cfg.xml
			Configuration config = new Configuration().configure();
			//创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
					applySettings(config.getProperties()).buildServiceRegistry();
			//读取xx.hbm.xml文件
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
