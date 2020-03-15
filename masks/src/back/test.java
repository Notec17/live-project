package back;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	private static String username ="root";
	private static String password ="123456";
	private static String url ="jdbc:mysql://localhost:3306/D6plus";
	public static Connection Connecteddatabase() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println();
		}
		return DriverManager.getConnection(url,username,password);
	}
	static boolean id_phnum_test(int n,String id,String phnum) throws SQLException {
		Connection connection =Connecteddatabase();
		Statement statement =connection.createStatement();
		String sql1 = "SELECT * FROM nlist WHERE n='"+n+"' and id ='"+id+"' ";
		String sql2 = "SELECT * FROM nlist WHERE n='"+n+"' and id ='"+phnum+"' ";
		ResultSet rs1=statement.executeQuery(sql1);
		ResultSet rs2=statement.executeQuery(sql2);
		if(rs1==null&&rs2==null) {
			return true;
		}
		else
		  return false;
	}
}
