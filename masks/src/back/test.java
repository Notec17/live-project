package back;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	private String username ="root";
	private String password ="123456";
	private String url ="jdbc:mysql://localhost:3306/D6plus";
	public Connection Connecteddatabase() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println();
		}
		return DriverManager.getConnection(url,username,password);
		
	}
}
