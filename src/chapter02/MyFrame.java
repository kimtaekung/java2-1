package chapter02;
import javax.swing.*;
public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("300x300 프레임");
        setSize(300, 300);
        setVisible(true);
    }    
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
