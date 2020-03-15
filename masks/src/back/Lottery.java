package back;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Lottery {

    public String number;
    private static String username="root";
    private static String password="123456";
    private static String url="jdbc:mysql://localhost:3306/d6plus?serverTimezone=GMT";

    /**
     * 获取中号的List 并且传进来的参数会处理成没有摇中的List
     * @param list 参与摇号的列表
     * @param num 摇号的数量
     * @return 抽中的列表
     */
    static List<String> runlottery(List<String> list, int num) {
        List<String> result = new ArrayList<>();
        while (num-- > 0 && list.size() > 0) {
            int index = (int)(Math.random() * list.size());
            result.add(list.get(index));
            list.remove(index);
        }
        return result;
    }

    public static Connection Connecteddatabase() throws SQLException {
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

    //获取最新批次是第几批
    public static int getLatestN() throws  SQLException {
        Connection c=Connecteddatabase();
        Statement s = c.createStatement();
        String sql="select n from nlist order by n DESC limit 1";
        int number = 0;
        ResultSet rs = s.executeQuery(sql);
        if (rs.next()) {
            number = rs.getInt(1);
        }
        rs.close();
        s.close();
        c.close();
        return number;
    }

    //获取指定批次的数量
    public static int getBatchNumber(int n) throws SQLException {
        Connection c=Connecteddatabase();
        Statement s = c.createStatement();
        String sql= "select count from nlist where n=" + n;
        ResultSet rs = s.executeQuery(sql);
        int number = 0;
        if (rs.next()) {
            number = rs.getInt(1);
        }
        rs.close();
        s.close();
        c.close();
        return number;
    }

    //获取指定批次的人的id
    public static List<String> getId(int batch) throws SQLException {
        Connection c=Connecteddatabase();
        Statement s = c.createStatement();
        String sql = "select id from booklist where n=" + batch;
        ResultSet rs = s.executeQuery(sql);
        List<String> result = new ArrayList<>();
        while (rs.next()) {
            result.add(rs.getString(1));
        }
        rs.close();
        s.close();
        c.close();
        return result;
    }

    //抽签，数据库
    static public void updateStatus() throws SQLException {
        int batch = getLatestN();
        int num = getBatchNumber(batch);
        List<String> list = getId(batch);
        List<String> result = runlottery(list, num);

        Connection c=Connecteddatabase();
        String sql="update nlist set status=1 where id=?";
        PreparedStatement preparedStatement = c.prepareStatement(sql);
        for (String data : result) {
            preparedStatement.setString(1, data);
            preparedStatement.executeQuery();
        }
        preparedStatement.close();
        c.close();
    }
}
