import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Students;

public class studenttest {

	private SessionFactory sessionfactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {

		Configuration config = new Configuration().configure(); // 创建配置对象；
		// 创建服务对象；
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂对象；
		sessionfactory = config.buildSessionFactory(serviceRegistry);
		// 会话对象;
		session = sessionfactory.openSession();
		// 开启事务
		
		transaction = session.beginTransaction();

	}

	@After
	public void destroy() {
		transaction.commit();// 提交事务；
		session.close();// 关闭会话；
		sessionfactory.close();// 关闭会话工厂；

	}

	@Test
	public void testwriteBlob() throws Exception {
		Students s = new Students(4, "陈傲雪", "girl", new Date(), "揭西");
		File f=new File("e:"+File.separator+"ax.jpg");
		InputStream input =new FileInputStream(f);
		Blob image=Hibernate.getLobCreator(session).createBlob(input, input.available());
		s.setPicture(image);
		session.save(s);

	}
	@Test
	public void testReadBlob() throws Exception{
		Students s=(Students)session.get(Students.class, 4);
		Blob image=s.getPicture();
		InputStream input =image.getBinaryStream();//获得照片的输入流；
		File f=new File("e:"+File.separator+"cyb.jpg");//创建输出流；
		OutputStream output=new FileOutputStream(f);//获得输出流；
		byte[] buff=new byte[input.available()];//创建缓冲区；
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
		
		
	}
	
}
