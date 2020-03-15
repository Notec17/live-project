package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGUI extends JFrame{

    JPanel jp1, jp2;
    JLabel hello;
    JButton order, query;

    public mainGUI(){
        jp1 = new JPanel();
        jp2 = new JPanel();

        hello = new JLabel("欢迎使用口罩预约系统1.0！");

        order = new JButton("预约");
        query = new JButton("查询");

        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //关闭窗口释放屏幕资源
                dispose();
                new orderGUI();
            }
        });

        //查询按钮，记得调用查询GUI****************
        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //关闭窗口释放屏幕资源
                dispose();
                new Findui();
                //此处调用************
            }
        });

        //采用网格布局三行一列
        this.setLayout(new GridLayout(2,1));

        //此JFrame加入JPanel
        this.add(jp1);
        this.add(jp2);

        //第一个JPanel加入欢迎语句
        jp1.add(hello);

        //第二个JPanel加入两个JButton
        jp2.add(order);
        jp2.add(query);

        this.setTitle("口罩预约");
        this.setSize(411,184);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置界面和虚拟机一起关闭
        this.setVisible(true);//设置界面可显示
    }

    public static void main(String[] args) {
        new mainGUI();
    }
}