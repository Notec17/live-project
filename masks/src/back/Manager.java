import java.sql.*;

public class Manager {
    private String userID;
    private String pwd;
    private String username="root";
    private  String password="123456";
    private String url="jdbc:mysql://localhost:3306/d6plus?serverTimezone=GMT";
    public Connection Connecteddatabase() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println();
        }
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //判断该管理员是否在数据库中
    public boolean isrightManager(String id,String pwd){
        this.pwd=pwd;
        this.userID=id;
        return true;
    }
}
