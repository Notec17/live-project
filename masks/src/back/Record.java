package back;

import java.sql.*;

public class Record {
    public String number;
    private String username="root";
    private  String password="123456";
    private String url="jdbc:mysql://localhost:3306/d6plus?serverTimezone=GMT";
    public String name;
    public String id;
    public String pnumber;
    public int mask_number;

    public void useMessage(int n,String id,String pnumber){
        //判断是否已经登记,跳出提示框
        //判断是否在此批次前三次中签,跳出提示框
        //预约成功,显示消息框
    }

}
