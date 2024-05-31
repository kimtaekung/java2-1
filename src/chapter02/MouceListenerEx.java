package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouceListenerEx extends JFrame {
    private JLabel la = new JLabel("Hello");

    public MouceListenerEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        la.setSize(150, 120);
        la.setLocation(30, 30);
        c.add(la);

        setSize(500, 500);
        setVisible(true);
    }
    class MyMouseListener extends MouseAdapter {
        public void mousepressd(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }
    public static void main(String[] args) {
        new MouceListenerEx();
    }
}
