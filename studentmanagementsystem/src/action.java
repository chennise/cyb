

import java.util.*;
import java.sql.Date;
import java.sql.SQLException;


public class action {
	public void add(Students goddess) throws Exception{
		add dao =new add();
		dao.addsuudent(goddess);
	}
	public void edit(Students goddess) throws Exception{
		add dao =new add();
		dao.updatestudent(goddess);
	}
	public void del(Integer id) throws Exception{
		add dao =new add();
		dao.delgodness(id);
	}
	public List<Students> show() throws Exception{
		add dao =new add();
		return dao.showbyscore();
	}
	public List<Students> query() throws Exception{
		add dao =new add();
		return dao.query();
	}
	public List<Students> query(List<Map<String, Object>> params) throws Exception{
		add dao =new add();
		return dao.query(params);
	}
	public Students get(Integer id) throws Exception{
		add dao =new add();
		return dao.get(id);
	}
	
}
