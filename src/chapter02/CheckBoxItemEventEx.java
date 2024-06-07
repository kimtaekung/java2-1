package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxItemEventEx extends JFrame {
    private JCheckBox [] fruits = new JCheckBox [3];
    private String [] names = {"사과", "배", "체리"};
    private JLabel sumLabel;

    public CheckBoxItemEventEx(ItemListener listener) {
        setTitle("체크박스와 ItemEvnet 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
        for(int i=0; i<fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            c.add(fruits[i]);
            fruits[i].addItemListener(listener);
        }
        sumLabel = new JLabel("현재 0 원 입니다.");
        c.add(sumLabel);
        setSize(250, 200);
        setVisible(true);
    }
    class MyIemListner extends ItemListener {
        private int sum =0;
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                if(e.getItem() == fruits[0])
                    sum += 500;
                else if(e.getItem() == fruits[1])
                    sum += 500;
                else
                    sum += 2000;
            }
            else {
                if(e.getItem() == fruits[0])
                    sum += 500;
                else if(e.getItem() == fruits[1])
                    sum += 500;
                else 
                    sum += 2000;
            }
            sumLabel.setText("현재 " + sum + "원 입니다.");
        }
    }
    public static void main(String[] args) {
        new CheckBoxItemEventEx();
    }
}
