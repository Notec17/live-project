package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class orderGUI extends JFrame{
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;
    JLabel name;
    JLabel id;
    JLabel phoneNum;
    JLabel orderMasksNum;
    JTextField nameText, idText, phoneNumText, masksNumText;
    JComboBox orderMasksNumBox;
    JButton startOrder, endOrder, commit;
    String []num ={"3","2","1"};//JComboBOX选项值
    public orderGUI(){
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

        name = new JLabel("真实姓名");
        id = new JLabel("身份证号");
        phoneNum = new JLabel("手机号：");
        orderMasksNum = new JLabel("预约口罩数量");

        nameText = new JTextField();
        nameText.setColumns(20);
        idText = new JTextField();
        idText.setColumns(20);
        phoneNumText = new JTextField();
        phoneNumText.setColumns(20);
        orderMasksNumBox = new JComboBox(num);
        masksNumText = new JTextField("100");//默认提供100个口罩
        masksNumText.setColumns(6);

        startOrder = new JButton("开始预约");
        endOrder = new JButton("结束预约");
        commit = new JButton("口罩数量");

        //开始预约按钮******************
        startOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //此处调用**************

            }
        });
        //结束预约按钮
        endOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //返回主界面
                JOptionPane.showMessageDialog(null, "不预约拉倒", "我先走一步", JOptionPane.ERROR_MESSAGE);
                dispose();
                new mainGUI();
            }
        });
        //口罩数量按钮
        commit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(masksNumText.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "你要凉了，没口罩预约了", "我先走一步", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    //这里调用函数*************
                }

            }
        });

        //采用网格布局5行2列
        this.setLayout(new GridLayout(6,2));

        //此JFrame加入6个JPanel
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);

        //总共五行2列
        jp1.add(name);
        jp1.add(nameText);

        jp2.add(id);
        jp2.add(idText);

        jp3.add(phoneNum);
        jp3.add(phoneNumText);

        jp4.add(orderMasksNum);
        jp4.add(orderMasksNumBox);

        jp5.add(commit);
        jp5.add(masksNumText);

        jp6.add(startOrder);
        jp6.add(endOrder);

        this.setTitle("信息录入");
        this.setSize(600,300);
        this.setLocation(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置界面和虚拟机一起关闭
        this.setVisible(true);//设置界面可显示
    }

    public static void main(String[] args) {
        new orderGUI();
    }
}
