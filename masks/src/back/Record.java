package back;

import java.sql.*;

public class Record {
    public String number;
    private String username="root";
    private  String password="123456";
    private String url="jdbc:mysql://localhost:3306/d6plus?serverTimezone=GMT";
    public String name;//姓名
    public String id;//身份证号
    public String pnumber;//手机号
    public int mask_number;//口罩数量
    public int status=0;//是否中签

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

    public boolean GetQuery(String a) throws SQLException {
        this.number=a;
        String sql="select code from booklist where code=?";
        Connection c=Connecteddatabase();
        ResultSet rs=null;
        PreparedStatement pstmt = null;
        pstmt=c.prepareStatement(sql);
        pstmt.setString(1,number);
        rs=pstmt.executeQuery();
        if(rs!=null){
            useMessage();
            close(rs,pstmt,c);
            return true;
        }
        else {
            close(rs,pstmt,c);
            return false;
        }
    }

    public void useMessage() throws SQLException{
        String sql1="select n from nlist order by n DESC limit 1";
        String sql2="select name,id,pnumber,count,status from booklist where code=?";
        Connection c=Connecteddatabase();
        ResultSet rs=null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        pstmt2=c.prepareStatement(sql2);
        pstmt2.setString(1,number);
        rs=pstmt2.executeQuery();
        while(rs.next()) {
            this.name = rs.getString("name");
            this.id = rs.getString("id");
            this.pnumber = rs.getString("pnumber");
            this.mask_number = rs.getInt("count");
            this.status = rs.getInt("status");
        }
        //判断是否已经登记,跳出提示框
        //判断是否在此批次前三次中签,跳出提示框
        //预约成功,显示消息框
    }

}
