package back;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

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

    //获取最新批次是第几批
    public int getLatestN() throws  SQLException {
        Connection c = DBUtil.getConnection();
        Statement s = c.createStatement();
        String="select n from nlist order by n DESC limit 1";
        int number = 0;
        if (rs.next())
            number = rs.getInt(1);
        s.close();
        c.close();
        return number;
    }

    //获取指定批次的数量
    public int getBatchNumber(int n) throws SQLException {
        Connection c = DBUtil.getConnection();
        Statement s = c.createStatement();
        String="select count from nlist where n=" + n;
        ResultSet rs = s.executeQuery(sql);
        int number = 0;
        if (rs.next())
            number = rs.getInt(1);
        s.close();
        c.close();
        return number;
    }

    //获取指定批次的人的id
    public List<String> getId(int batch) throws SQLException {
        Connection c = DBUtil.getConnection();
        Statement s = c.createStatement();
        String sql = "select id from booklist where n=" + batch;
        ResultSet rs = s.executeQuery(sql);
        List<String> result = new ArrayList<>();
        while (rs.next())
            result.add(rs.getString(1));
        return result;
    }

    //抽签，数据库
    static public void updateStatus() throws SQLException {
        int batch = getLatestN();
        int num = getBatchNumber(batch);
        List<String> list = getId(batch);
        List<String> result = runlottery(list, num);

        Connection c = DBUtil.getConnection();
        String sql="update nlist set status=1 where id=?";
        PreparedStatement preparedStatement = c.prepaerStatement(sql);
        for (data : result) {
            preparedStatement.setString(1, data);
            preparedStatement.executeQuery();
        }
        preparedStatement.close();
        c.close();
    }
}
