package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyCharEx extends JFrame {
    private JLabel la =
        new JLabel("<Enter>키로 배경색이 바뀝니다");

    public keyCharEx() {
        super("keyListener의 문자 키 입력 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(la);
        c.addKetlistener(new MyKeyListener());
        setSize(250, 150);
        setVisible(true);
        c.setFocusable(true);
        c.requestFocus();   
        }
        class MyketListener extends KeyAdapter {
            public void keyPressed(keyEvent e) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);

                switch(e.getKeyChar()) {
                    case '\n': // <Enter> 키 입력
                    la.setText("r=" + r + ",g=" + g + ",b=" + b);
                    getContentPane().setBackground(
                                        new Color(r, g, b));
                    break;
                case 'q':
                    System.exit(0);
                }
            }
        }
        public static void maini(String[] args) {
            new KeyCharEx();
        }
}