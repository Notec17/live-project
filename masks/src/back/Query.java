package back;

import java.sql.*;

public class Query {
    public String number;
    private String username="root";
    private  String password="123456";
    private String url="jdbc:mysql://localhost:3306/d6plus?serverTimezone=GMT";
    public String name;//姓名
    public String id;//身份证号
    public String pnumber;//手机号
    public int mask_number;//口罩数量

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
    public boolean GetQuery(String a) throws SQLException {
        this.number=a;
        String sql="select code from masklist where code=?";
        Connection c=Connecteddatabase();
        ResultSet rs=null;
        PreparedStatement pstmt = null;
        pstmt=c.prepareStatement(sql);
        pstmt.setString(1,number);
        rs=pstmt.executeQuery();
        if(rs!=null){
            Getinformation();
            close(rs,pstmt,c);
            return true;
        }
        else {
            close(rs,pstmt,c);
            return false;
        }
    }

    

}
