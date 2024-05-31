package chapter02;
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame{
    public GridLayoutEx() {
        super("GridLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        // 1x10의 GridLayout 배치관리자
        contentPane.setLayout(new GridLayout(4, 3, 10, 10));

        for(int i=1; i<10; i++) { // 10개의 버튼 부착
            String text = Integer.toString(i); // i를 문자열로 변환
            contentPane.add(new JButton(text)); // 컨텐트팬에 버튼 부착
        }
        contentPane.add(new JButton("*"));  // 컨텐트팬에 버튼 부착
        contentPane.add(new JButton("0"));  // 컨텐트팬에 버튼 부착


        setSize(500, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GridLayoutEx();
    }
    
}