package back;


import java.sql.Connection;
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
	static boolean id_phnum_test(int n,String id,String phnum) throws SQLException {//为当前批次
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
	static boolean id_phnum_threetime(int n,String id,String phnum)throws SQLException{
		Connection connection =Connecteddatabase();
		Statement statement =connection.createStatement();
		int a=n-3,b=n-2,c=n-1;
		String sql1 = "SELECT * FROM nlist WHERE n='"+a+"' and id ='"+id+"' and status=1";
		String sql2 = "SELECT * FROM nlist WHERE n='"+b+"' and id ='"+id+"' and status=1";
		String sql3 = "SELECT * FROM nlist WHERE n='"+c+"' and id ='"+id+"' and status=1";
		String sql4 = "SELECT * FROM nlist WHERE n='"+b+"' and id ='"+phnum+"' and status=1";
		String sql5 = "SELECT * FROM nlist WHERE n='"+b+"' and id ='"+phnum+"' and status=1";
		String sql6 = "SELECT * FROM nlist WHERE n='"+b+"' and id ='"+phnum+"' and status=1";
		
		ResultSet rs1=statement.executeQuery(sql1);
		ResultSet rs2=statement.executeQuery(sql2);
		ResultSet rs3=statement.executeQuery(sql3);
		ResultSet rs4=statement.executeQuery(sql4);
		ResultSet rs5=statement.executeQuery(sql5);
		ResultSet rs6=statement.executeQuery(sql6);
		if(rs1==null&&rs2==null&&rs3==null&&rs4==null&&rs5==null&&rs6==null) {
			return true;
		}
		else
		    return false;
	}
}
