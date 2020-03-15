package back;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	static boolean id_phnum_test(int n,String id,String phnum) throws SQLException {//nΪ��ǰ����,idΪ���֤�ţ�phnumΪ�ֻ���
		Connection connection =Connecteddatabase();
		String sql1 = "SELECT * FROM bookList WHERE n=? and id =? ";
		String sql2 = "SELECT * FROM bookList WHERE n=? and phnum =? ";
		PreparedStatement statement1 =connection.prepareStatement(sql1);
		statement1.setInt(1,n);
		statement1.setString(2,id);
		PreparedStatement statement2 =connection.prepareStatement(sql2);
		statement2.setInt(1,n);
		statement2.setString(2,phnum);
		ResultSet rs1=null;
		ResultSet rs2=null;
		rs1=statement1.executeQuery();
		rs2=statement2.executeQuery();
		rs1.last();
		rs2.last();
		if(rs1.getRow()==0&&rs2.getRow()==0) {
			close(rs1,statement1,connection);
			close(rs2,statement2,connection);
			return true;
		}
		else
		{
			close(rs1,statement1,connection);
			close(rs2,statement2,connection);
			return false;
		}
	}
	static boolean id_phnum_threetime(int n,String id,String phnum)throws SQLException{//nΪ��ǰ����,idΪ���֤�ţ�phnumΪ�ֻ���
		Connection connection =Connecteddatabase();
		int a=n-3,b=n-2,c=n-1;
		String sql1 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		String sql2 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		String sql3 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		String sql4 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		String sql5 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		String sql6 = "SELECT * FROM bookList WHERE n=? and id =? and status=1";
		PreparedStatement statement1 =connection.prepareStatement(sql1);
		statement1.setInt(1,a);
		statement1.setString(2,id);
		PreparedStatement statement2 =connection.prepareStatement(sql2);
		statement2.setInt(1,a);
		statement2.setString(2,phnum);
		PreparedStatement statement3 =connection.prepareStatement(sql3);
		statement3.setInt(1,b);
		statement3.setString(2,id);
		PreparedStatement statement4 =connection.prepareStatement(sql4);
		statement4.setInt(1,b);
		statement4.setString(2,phnum);
		PreparedStatement statement5 =connection.prepareStatement(sql5);
		statement5.setInt(1,c);
		statement5.setString(2,id);
		PreparedStatement statement6 =connection.prepareStatement(sql6);
		statement6.setInt(1,c);
		statement6.setString(2,phnum);
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		ResultSet rs6=null;
		rs1=statement1.executeQuery();
		rs2=statement2.executeQuery();
		rs3=statement3.executeQuery();
		rs4=statement4.executeQuery();
		rs5=statement5.executeQuery();
		rs6=statement6.executeQuery();
		rs1.last();
		rs2.last();
		rs3.last();
		rs4.last();
		rs5.last();
		rs6.last();
		if(rs1.getRow()==0&&rs2.getRow()==0&&rs3.getRow()==0&&rs4.getRow()==0&&rs5.getRow()==0&&rs6.getRow()==0) {
			close(rs1,statement1,connection);
			close(rs2,statement2,connection);
			close(rs3,statement3,connection);
			close(rs4,statement4,connection);
			close(rs5,statement5,connection);
			close(rs6,statement6,connection);
			return true;
		}
		else
		{
			close(rs1,statement1,connection);
			close(rs2,statement2,connection);
			close(rs3,statement3,connection);
			close(rs4,statement4,connection);
			close(rs5,statement5,connection);
			close(rs6,statement6,connection);
		    return false;}
		
	}
}
