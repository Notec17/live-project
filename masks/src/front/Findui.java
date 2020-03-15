package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Findui {
    public void builldFindui() {
        JFrame jf = new JFrame("查询窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        // 创建文本框，指定可见列数为8列
        final JTextField textField = new JTextField(8);
        textField.setFont(new Font(null, Font.PLAIN, 20));
        panel.add(textField);


        //创建一个文本展示查询的内容
        JTextArea Area=new JTextArea();
        JLabel label=new JLabel("编号");
        panel.add(label);
        panel.add(Area);
        // 创建一个按钮，点击后获取文本框中的文本
        JButton btn = new JButton("查询");
        btn.setFont(new Font(null, Font.PLAIN, 20));
        btn.addActionListener(new ActionListener() {
            @Override
            //鼠标点击查询后文本框内容传入doit（）进行查询
            public void actionPerformed(ActionEvent e) {
                doit(textField.getText());
                System.out.println("查询: " + textField.getText());
            }

            private void doit(String text) {
                //查询操作完成后调用display展示预约详情
                //
                //
                //
                Display("张三","350582199810175519","15905926688",50);
            }
            //name shenfen shouji kouzhao
            private void Display(String name,String shenfen,String shouji,int kouzhao) {
                Area.append("姓名: "+name+"\n");
                Area.append("身份证: "+shenfen+"\n");
                Area.append("手机号: "+shouji+"\n");
                Area.append("口罩数量: "+kouzhao+"\n");
            }

        });
        panel.add(btn);
        jf.setContentPane(panel);
        jf.setVisible(true);
    }
    public static void main(String[] args) throws AWTException {
       Findui Find=new Findui();
       Find.builldFindui();
    }

}