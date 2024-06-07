package chapter02;
import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
    public RadioButtonEx() {
        setTitle("라디오버튼 만들기 에제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        containers c = getContentPane();
        c.setLayout(new FlowLayout());
        ButtonGroup g = new ButtonGroup();

        imageIcon img = new ImageIcon("images/gesling.jpg");

        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배", true);
        JRadioButton cherry = new JRadioButton(img);

        g.add(apple);
        g.add(pear);
        g.add(cherry);

        c.add(apple); c.add(pear); c.add(cherry);
        setSize(2250, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RadioButtonEx();
    }
    
}
