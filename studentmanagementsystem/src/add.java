import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class add {
	
	
	public void addsuudent(Students g) throws SQLException{
		Connection conn= DB.getconnection();
		String sql=""+"insert into cyl"+
		"(id,name,score1,score2,score3,score)"+"values("+"?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, g.getSid());
		ptmt.setString(2, g.getSname());
		ptmt.setInt(3, g.getScore1());
		ptmt.setInt(4, g.getScore2());
		ptmt.setInt(5, g.getScore3());
		ptmt.setInt(6, g.getScore4());
	
		ptmt.execute();
	}

	public void updatestudent(Students g) throws SQLException{
		
		Connection conn= DB.getconnection();
		String sql=""+
		" update cyl"+
		" set name=?,score1=?,score2=?,score3=?,score=?"+
		" where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, g. getSname());
		ptmt.setInt(2, g.getScore1());
		ptmt.setInt(3, g.getScore2());
		ptmt.setInt(4, g.getScore3());
		ptmt.setInt(5, g.getScore4());
		ptmt.setInt(6, g.getSid());
		ptmt.execute();
		
	}
	public List<Students> showbyscore() throws SQLException{
		List<Students> result =new ArrayList<Students>();
		Connection conn= DB.getconnection();
		StringBuilder s=new StringBuilder();
		s.append(" select * from cyl  order by score desc");
	    System.out.println(s.toString());
		PreparedStatement ptmt=conn.prepareStatement(s.toString());//预编译
		ResultSet rs=ptmt.executeQuery();	 //进行查询；
		while(rs.next()){
			Students g=new Students();
			g.setSid(rs.getInt("id"));
			g.setSname(rs.getString("name"));
			g.setScore1(rs.getInt("score1"));
			g.setScore2(rs.getInt("score2"));
			g.setScore3(rs.getInt("score3"));
			g.setScore4(rs.getInt("score"));
			result.add(g); 
		}
		 return result;
		
	}
	public void delgodness(Integer id) throws SQLException{
		Connection conn= DB.getconnection();
		String sql=""+
		" delete from cyl"+
		" where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
		
	}
	//查询
	public List<Students> query() throws SQLException{
		List<Students> result =new ArrayList<Students>();
		Connection conn= DB.getconnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from cyl");
	    System.out.println(sb.toString());
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());//预编译
		ResultSet rs=ptmt.executeQuery();	 //进行查询；
		Students g=null; 
		while( rs.next()){
			g=new Students();
			g.setSid(rs.getInt("id"));
			g.setSname(rs.getString("name"));
			g.setScore1(rs.getInt("score1"));
			g.setScore2(rs.getInt("score2"));
			g.setScore3(rs.getInt("score3"));
			g.setScore4(rs.getInt("score"));
		
			result.add(g);
		}
		return result;
		
	}
	public List<Students> query(List<Map<String, Object>> params) throws SQLException{
		List<Students> result =new ArrayList<Students>();
		Connection conn= DB.getconnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" select * from cyb where 1=1");
	    if(params !=null&&params.size()>0){
	    	for (int i = 0; i < params.size(); i++) {
	    		Map<String, Object> map =params.get(i);
	    		sb.append(" and "+map.get("name")+""+map.get("rela")+""+map.get("value")+"");
			}
	    }
	    System.out.println(sb.toString());
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());//预编译
		ResultSet rs=ptmt.executeQuery();	 //进行查询；
		Students g=null; 
		while( rs.next()){
			g=new Students();
			g.setSid(rs.getInt("id"));
			g.setSname(rs.getString("name"));
			g.setScore1(rs.getInt("score1"));
			g.setScore2(rs.getInt("score2"));
			g.setScore3(rs.getInt("score3"));
			g.setScore4(rs.getInt("score"));
			result.add(g);
		}
		return result;
		
	}
	public Students get(Integer id) throws SQLException{
		Students g=null;
		Connection conn= DB.getconnection();
		String sql=""+
		" select * from cyl"+
		" where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			g=new Students();
			g.setSid(rs.getInt("id"));
			g.setSname(rs.getString("name"));
			g.setScore1(rs.getInt("score1"));
			g.setScore2(rs.getInt("score2"));
			g.setScore3(rs.getInt("score3"));
			g.setScore4(rs.getInt("score"));		
		}
		
		return g;
	}
}
