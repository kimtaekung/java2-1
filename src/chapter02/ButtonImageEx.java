package chapter02;

import javax.swing.*;
import java.awt.*;

public class ButtonImageEx extends JFrame {
        public ButtonImageEx() {
            setTitle("이미지 버튼 예제");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container c = getContentPane();
            c.setLayout(new FlowLayout());

            ImageIcon normalIcon = new ImageIcon("images/call.gif");
            ImageIcon rolloverIcon = new ImageIcon("images/gosling.jpg");
            ImageIcon pressedIcon = new ImageIcon("images/call.gif");

            JButton btn = new JButton("call~~", normalIcon);
            btn.setPressedIcon(pressedIcon);
            btn.setRolloverIcon(rolloverIcon);

            c.add(btn);
            setSize(250, 150);
            setVisible(true);
        }
        public static void main(String[] args) {
            new ButtonImageEx();
        }
}
