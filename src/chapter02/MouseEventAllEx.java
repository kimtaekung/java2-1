package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventAllEx extends JFrame {
    private Jlabel la = new Jlabel(" Move Me");

    public MouseEventAllEx() {
        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        Container c = getContentPane();
        MyMouseListener listener = 
                                        new MouseEventAllEx();
        c.addHouseListener(listener);
        c.addMouseMotionListener(listener);
    }
}
