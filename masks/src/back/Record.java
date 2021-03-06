package back;

import javax.swing.*;
import java.sql.*;
import java.util.UUID;

public class Record {
    public String number;
    private String username="root";
    private String password="123456";
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

    public int GetRecord(String id,String pnumber,int n) throws SQLException {
        if(!test.id_phnum_test(n, id, pnumber) || !test.id_phnum_threetime(n, id, pnumber)){
            return 0;
        }
        return 1;
    }

    public void useMessage(String id,String pnumber,String name,int count) throws SQLException{
        int ln=Lottery.getLatestN();
        String code= UUID.randomUUID().toString().replace("-", "").toUpperCase();

        if(GetRecord(id,pnumber,ln)==1){
            Connection c=Connecteddatabase();
            String sql_insert="insert into booklist values(?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql_insert);
            ps.setInt(1, ln);
            ps.setString(2, name);
            ps.setString(3, id);
            ps.setString(4, pnumber);
            ps.setInt(5, count);
            ps.setInt(6, 0);
            ps.setString(7, code);
            ps.executeUpdate();
            ps.close();
            c.close();
            JOptionPane.showMessageDialog(null,"您本次的预约编号为"+code,"恭喜",JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"预约失败：您已经预约过了或在前三期已经中过签，请把机会留给其他人","遗憾",JOptionPane.PLAIN_MESSAGE);
        }
        //判断是否已经登记,跳出提示框
        //判断是否在此批次前三次中签,跳出提示框
        //预约成功,显示消息框
    }

}
