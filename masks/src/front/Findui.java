package front;
import back.Query;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

        // 创建一个按钮，点击后获取文本框中的文本
        JButton btn = new JButton("查询");
        btn.setFont(new Font(null, Font.PLAIN, 20));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    doit(textField.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                System.out.println("查询: " + textField.getText());
            }

            private void doit(String text) throws SQLException {
                Query a=new Query();
                a.GetQuery(text);
                System.out.println("hhhhh");
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