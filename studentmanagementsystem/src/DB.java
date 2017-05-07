

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	 private static final String URL="jdbc:mysql://127.0.0.1:3306/manager";
	 private static final String NAME="root";
	 private static final String PASSWORD="123456";
	 private static Connection conn=null;
	 static{
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 conn =DriverManager.getConnection(URL,NAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static Connection  getconnection(){
		 return conn;
	 }
	
 public static void main(String[] args)throws Exception{
	
	 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 Connection conn =DriverManager.getConnection(URL,NAME,PASSWORD);
	 Statement stmt=conn.createStatement();
	 ResultSet rs=stmt.executeQuery("select user_name,age from cyl");
	while( rs.next()){
		System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
		
	}
 }

}
