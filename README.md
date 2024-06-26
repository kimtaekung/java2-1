## 202330109 김태경

## 6월 14일
## 자바의 입출력 스트림
    자바의 입출력 스트림
        입출력 장치와 자바 응용 프로그램 연결
            입력 스트림 : 입력 장치로부터 자바 프로그램으로 데이터를 전달하는 객체
            출력 스트림 : 자바 프로그램에서 출력 장치로 데이터를 보내는 객체
        특징
            입출력 스트림 기본 단위 : 바이트
            단방향 스트림, 선입선출 구조


## 사바의 입출력 스트림 종류
    문자 스트림
        문자만 입출력하는 스트림
        문자가 아닌 바이너리 데이터는 스트림에서 처리 못 함
        문자가 아닌 데이터를 스트리믕로 출력하면 기호가 깨짐
        바이너리 파일 문자 스트리믕로 일으면 읽을 수 없는 바이트 생성
    
    바이트 스트림
        입출력 데이터를 단순 바이트의 흐름으로 처리
        문자 데이터 든 바이너리 데이터든 상관없이 처리 가능


## 스트림 연결
    여러 개의 스트림을 연결하여 사용할 수 있음


## 문자 스트림으로 텍스트 파일 읽기
    텍스트 파일을 읽기 위해 문자 스트림 FileReader 클래스 이용
        1. 파일 일력 스트림 생성(파일 열기)
            스트림을 생성하고 파잉응ㄹ 열어 스트림과 연결

        2. 파일 읽기
            read()로 문자 하나 씩 파일에서 읽음

        3. 스트림 닫기
            스트림이 더 이상 필요 없으면 닫아야 함. 닫힌 스트림에서는 읽을 수 없음
            close()로 스트림 닫기


## 파일 입출력과 예외 처리
    파일 입출력 동안 예외 발생 가능
        스트림 생성 동안 : FileNotFoundException 발생 가능
            파일의 경로명이 틀리거나, 디스크고장 등으로 파일을 열 수 없음
        
        파일 읽, 쓰기, 닫기를 하는 동안 : IOException 발생 가능
            디스크 오동작, 파일이 중간에 깨진 경우, 디스크 공간이 모자라서 파일 입출력 불가

    try-catch 블록 반드시 필요
        자바 컴파일러의 강제 사항


```java
import java.io.*;

public class FileReaderEx {
    public static void main(String[] args) {
        FileReader in = null;
        try {
            in = new FileReader("c:\\windows\\system.ini");
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
            }
            in.close();
        }
        catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
```


## 문자 스트림으로 텍스트 파일 쓰기
    텍스트 파일에 쓰기 위해 문자 스트림 FileWriter 클래스 이용
        1. 파일 출력 스트림 생성(파일 열기)
            스트림을 생성하고 파일을 열어 스트림과 연결

        2. 파일 쓰기
            write()로 문자 하나 씩 파일에 기록

            블록 단위로 쓰기 가능

        3. 스트림 닫기
            close()로 스트림 닫기


```java
import java.io.*;

public class FileReaderEx {
    public static void main(String[] args) {
        InputStreamReader in = new InputStreamReader(System.in);

        FileWriter fout = null;
        int c;
        try {
            fout = new FileWriter("c:\\temp\\test.txt");
            while ((c = in.read()) != -1) {
                fout.write(c);
            }
            in.close();
            fout.close();
        }
        catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
```


## 바이트 스트림으로 바이너리 파일 쓰기
    바이너리 값을 파일에 저장하기
        프로그램 내의 변수, 배열, 버퍼에 든 바이너리 값을 파일에 그대로 기록
            FileOutputStream 클래스 이용
        
        1. 파일 출력 스트림 생성(파일 열기)
            스트림을 생성하고 파일을 열어 스트림과 연결
        
        2. 파일 쓰기
            write()로 문자 하나 씩 파일에 기록
        
        3. 스트림 닫기
            close()로 스트림 닫기


```java
import java.io.*;
public class FileinputStreamEx {
    public static void main(String[] args) {
        byte b [] = new byte [6];
        try {
            FileInputStream fin =
                new FileInputStream("c:\\Temp\\test.out");
            int n=0, c;
            while((c = fin.read())!= -1) {
                b[n] = (byte)c;
                n++;
            }

            System.out.println(
                "c:\\Temp\\test.out에서 일은 배열을 출력합니다.");
            for(int i=0; i<b.length; i++)
                System.out.print(b[i]+" ");
            System.out.println();

            fin.close();
        } catch(IOException e) { }
    }
}
```


## TCP/IP 소개
    TCP/IP 프로토콜
        두 시스템 간에 데이터가 손상없이 안전하게 전송되도록 하는 통신 프로토콜
        TCP에서 동작하는 응용프로그램 사례
            e-mail, FIP, 웹(HTTP) 등

    TCP/IP특징
        연결형 통신
            한 번 연결 후 계속 데이터 전송 가능
        보낸 순서대로 받아 응용프로그램에게 전달


## IP 주소
    IP 주소
        네트워크 상에서 유일하게 식별될 수 있는 컴퓨터 주소
            숫자로 구성된 주소
            4개의 숫자가 '.'으로 연결
                ex) 192.156.11.15

    숫자로 된 주소는 기억하기 어려우므로 www.naver.com과 같은 문자열로 구성된 도메인 이름으로 바꿔ㅓ 사용
        DNS(Domain Name System)
            문자열로 구성된 도메인 이름을 숫자로 구성된 IP 주소로 자동 변환

    현재는  32비트의 IP 버ㅓㄴ 4(IPv4)가 사용되고 있음
        IP 주소 고갈로 인해 128비트 IP 버전 6(IPv6)이 점점 사용되는 추세
    
    자신의 IP 주소를 간단히 locallhost라는 이름으로 사용 가능


## 포트 
    포트
        통신하는 프로그램 간에 가상의 연결단 포트 생성
            IP 주소는 네트워크 상의 컴퓨터 또는 시스템을 식별하는 주소
            포트 번호를 이용하여 통신할 응용프로그램 실벽

        모든 응용프로그램은 하나 이상의 포트 생성 가능
            포트를 이용하여 상대방 응용프로그램과 데이터 교환

        잘 알려진 포트(well-known ports)
            시스템이 사용하는 포트 번호
            잘 알려진 응용프로그램에서 사용하는 포트 번호
            0부터 1023 사이의 포트 번호
            ex) SSH 22, HTTP 80, FTP 21

        잘 알려진 포트 번호는 개발자가 사용하지 않는 것이 좋음
            충돌 가능성이 있음


## 소켓 프로그래밍
    소켓 (socket)
        TCP/IP 네트워크를 이용하여 쉽게 통신 프로그램을 작성하도록 지원하는 기반 기술
    소켓
        두 응용프로그램 간의 양방향 통신 링크의 한쪽 끝 단
        소켓끼리 데이터를 주고받음
        소켓은 특정 IP 포트 번호와 결합
    자바로 소켓 통신할 수 있느 ㄴ라이브러리 지원
    소켓 종류 : 서버 소켓과 클라이언트 소켓


## Socket 클래스, 클ㄹ이언트 소켓
    Socket 클래스
        클라이언트 소켓에 사요되는 클래스
        java.net 패키지에 포함
        생성자
        

## 클라이언트에서 소켓으로 서버에 접속하는 코드
    클라이언트 소켓 생성 및 서버에 접속
        socket의 생성자에서  128.12.1.1의 주소의 9999포트에 접속
    
    소켓으로부터 데이터를 전송할 입출력 스트림 생성

    서버로 데이터 전송
        flush()를 호출하면 스트림 속에 데이터 모두 전송

    서버로부터 데이터 수신

    네트워크 접속 종료

## 서버에 클라이언트가 연결되는 과정
    서버는 서버 소켓으로 들어오는 연결 요청을 기다림(listen)

    클라이언트가 서버에게 연결 요청

    서버가 연결 요청 수락(accept)
        새로운 클라이언트 소켓을 만들어 클라이언트오 통신하게 함
        그리고 다시 다른 클라이언트의 연결을 기다림


## 서버가 클라이언트와 통신하는 과정
    서버 소켓 생성
        서버는 9999 포트에서 접속 기다리는 포트로 9999 선택
    
    클라이언트로부터 접속 기달림
        accept() 메소드는 접속 요청이 오면 접속 후 새 Socket 객체 반환
        접속 후 새로 만들어진  Socket 객체를 통해 클라이언트와 통신
    
    네으퉈크 입출력 스트림 생성
        Socket 객체의  getInputStream()과 getOutputStream() 메소드를 이용하여 입출력 데이터 스트림 생성

    
## 서버-클라이언트 채팅 프로그램 만들기
    간단한 채팅 프로그램
        서버와 클라이언트가  1:1로 채팅

        클라이언트와 서버가 서로 한번씩 번갈아 가면서 문자열 전송
            문자열 끝에 "\n"을 덧붙여 보내고 라인 단위로 수신

        클라이언트가 bye를 보내면 프로그램 종료


```java
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEx {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        ServerSocket listener = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            listener = new ServerSocket(9999);
            System.out.println("연결을 기다리고있습니다....");
            socket = listener.accept();
            System.out.println("연결되었습니다.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String inputMessage = in.readLine();
                if (inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트에서 bye로 연결을 종료하였음");
                    break;
                }
                System.out.println("클라이언트: " + inputMessage);
                System.out.print("보내기>>");
                String outputMessage = scanner.nextLine();
                out.write(outputMessage + "\n");
                out.flush();
            }
        } catch (IOException e) { System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close();
                socket.close();
                listener.close();
            } catch (IOException e) { System.out.println("클라이언트와 채팅 중 오류가 발생했습니다."); }
        }
    }    
}
```




## 6월 7일
## 스윙 컴포넌트 그리기
    스윙의 페인팅 기본
        모든 컴포넌트는 자신의 모양을 스스로 그린다
        컨테이너는 자신을 그린 후 그 위에 자식 컴포넌트들에게 그리기 지시
        모든 스윙 컴포넌트는 자신의 모양을 그리는 paintComponent() 메소드 보유
    
    public void paintComponent(Graphics g)
        스윙 컴포넌트가 자신의 모을 그리는 메소드
        JComponent의 메소드 : 모든 스윙 컴포넌트가 이 메소드를 오버라이딩함
        언제 호출 되는가
            컴포넌트가 그려져야 하는 시점마다 호출
            크기가 변경, 위치 변경, 컴포넌트가 가려졌을 경우등
        매개변수인 Graphics 객체
            그래픽 컨텍스트 : 컴포넌트 그리기에 필요한 도구를 제공하는 객체
            자바 플랫폼에 의해 공급
            색 지정, 도형 그리기, 클리핑, 이미지 그리기 등이 메소드 제공
    

## paintComponent()의 오버라이딩과  JPnel
    paintComponent(Graphic g)의 오버라이딩
        개발자가 JComponent를 상속받아 새로운 컴포넌트 설계

    JPanel
        비어 있는 컨테이너
        개발자가 다양한 GI를 창출할 수 있느 ㄴ캔버스로 적합
        JPnel을 상속받아 개발자 임의의 모양을 가지는 패널로 많이 사용


```java
import javax.swing.*;
import java.awt.*;

public class paintJPanelEX extends JFrame {
    public paintJPanelEX() {
        setTitle("JPanel의  paintComponent() 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(250, 200);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(10, 10, 50, 50);
            g.drawRect(50, 50, 50, 50);

            g.setColor(Color.MAGENTA);
            g.drawRect(90, 90, 50, 50);
        }
    }

    public static void main(String[] args) {
        new paintJPanelEX();
    }
    
}
```


## 그래픽 기반 GUI 프로그래밍
    그래픽 기반 GUI 프로그래밍
        스윙 컴포넌트에 의존하지 않고 선, 원 이미지 등을 이용하여 직접 화면응ㄹ 구성하는 방법
        그래픽 기반 GUI 프로그래밍의 학습이 필요한 이유
            컴포넌트의 한계를 극복하고 차트,  게임 등 자유로운 콤텐트 표현
            그래픽은 컴포넌트에 비해 화면 출력 속도가 빠름
            스윙 컴포넌트들로 모두 그래픽으로 작성되어 있어, 그래픽에 대한 학습은 자바 GUI의 바탕 기술을 이해하는데 도움
            그래픽을 이용하여 개발자 자신만의 컴포넌트 개발


## Graphics와 문자열 출력
    Graphics의 기능
        색상 선택하기 
        문자열 그리기
        도형 그리기
        도형 칠하기
        이미지 그리기
        클리핑

## 그래픽의 색과 폰트
    색 : color 클래스
    폰트 : font 클래스
    Grapchics에 색과 폰트 설정


## 도형 그리기와 칠하기
    도형 그리기
        선, 타원, 사각형, 둥근 모서리 사각형, 원호, 페 다각형 그리기
        선 굵기 조절 X

    도형 칠하기
        도형을 그리고 내부를 칠하는 기능
            도형의 외락선과 내부를 따로 칠하는 기능 없음
        도형 칠하기위한 메소드
        그리기 메소드 명에서 draw 대신 fill로 이름 대치

```java
import javax.swing.*;
import java.awt.*;

public class paintJPanelEX extends JFrame {
    public paintJPanelEX() {
        setTitle("JPanel의  paintComponent() 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(250, 200);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(10, 10, 50, 50);
            g.drawString("자바가 정말 재밋다.~~", 30, 30);
            g.setColor(new Color(255, 0, 0));
            g.setFont(new Font("Arial", Font.ITALIC, 30));
            g.setColor(new Color(0x00ff00ff));
            g.drawLine(20, 20, 100, 100);
            g.drawOval(20, 300, 80, 80);
            g.drawRoundRect(20, 20,120,80,40,60);
            g.drawArc(20, 200,80,80,90,270);

            int []x = {80,40,80,120,90};
            int []y = {40,120,200,120,100};
            g.fillPolygon(x, y, 5);
        }
    }

    public static void main(String[] args) {
        new paintJPanelEX();
    }
    
}
```

## 스윙에서 이미지를 그리는 2가지 방법
    JLabel을 이용한 이미지 그리기
        장점 : 이미지 그리기 간편 용이
        단점 : 이미지 원본 크기대로 그리므로 이미지 크기 조절 불가
        
    Graphics의 drawImage()로 이미지 출력
        장점 : 이미지 일부분 등 이미지ㅡ의 원본 크기와 다르게 그리기 가능
        단점 : 컴포넌트로 관리 할 수 없음 이미지의 위치나 크기 등을 적절히 조절하는 코딩 필요

```java

```
## repaint()
    repaint()
        모든 컴포넌트가 가지고 있는 메소드
        자바 플랫폼에게 컴포넌트 그리기를 강제 지시하는 메소드
        repaint()를 호출하면, 자바 플랫폼이 컴포넌트의 paintComponent() 호출

    repaint()의 호출이 필요한 경우
        개발자가 컴포넌트를 다시 그리고자 하는 경우
            프로그램에서 컴포넌트의 모양과 위치를 변경하고 바로 화면에 반영시키고자 하는 경우
            컴포넌트가 다시 그려져야 그 때 변경된 위치에 변경된 모양으로 출력함
            repaint()는 자바 플랫폼에게 지금 당장 컴포넌트를 다시 그리도록 지시함

    부모 컴포넌트부터 다시 그리는 것이 좋음
        컴포넌트 repaint()가 불려지면
            이컴포넌트는 새로운 위치에 다시 그려지지만 이전의 위치에 있던 자신의 모양이 남아 있음
        부모 컴포넌트의 repaint()를 호출하면
            부모 컨테이너의 모든 내용을 지우고 자식을 다시 그리기 때문에 컴포넌트의 이전 모양이 지워지고 새로 변경된 크기나 위치에 그려짐

## 멀티태스킹 개념
    멀티태스킹
        여려개의 작업(태스크)이 동시에 처리되는 것

## 스레드와 운영체제
    스레드
        운영체제에 의해 관리되는 하나의 작업 혹은 태스크
        스레드와 태스크(혹은 작업)은 바꾸어 사용해도 무관

    멀티스레딩
        여러 스레드를 동시에 실행시키는 응용프로그램을 작성ㅇ하는 기법

    스레드 구성
        스레드 코드
            작업을 실행하기 위해 작성한 프로그램 코드
            개발자가 작성
        
        스레드 정보
            스레드 명, ID, 실행 소요 시간, 우선 순위 등
            우영체제가 스레드에 대해 관리하는 정보


## 멀티태스킹과 멀티스레딩
    멀티태스킹 구현 기술
        멀티프로세싱
            하나의 응용프로그램이 여러 개의 프로세스를 생성하고, 각 프로세스가 하나의 작업을 처리하는 기법
            각 프로세스 독립된 메모리 영역을 보유하고 실행
            프로세스 사이의 문맥 교환에 따른 과도한 오버헤드와 시간 소모의 문제점

        멀티스레딩
            하나의 응용프로그램이 여러 개의 스레드를 생성하고, 각 스레드가 하나의 작업을 처리하는 기법
            하나의 응용프로그램에 속한 스레드는 변수 메모리, 파일 오픈 테이블 등 자원을 공유하므로, 문맥 교환에 따른 오버헤드가 매주 작음
            현재 대부분읜 운영체제가 멀티스레딩을 기본으로 하고 있음


## 자바 스레드
    자바 스레드
        자바 가상 기계(jvm)에 의해 스케쥴되는 실행 단위의 코드 블럭
        스레드의 생명주기는 jvm에 의해 관리됨 : jvm은 스레드 단위로 스케쥴링

    jvm과 자바의 멀티스레딩
        하나의 jvm은 하나의 자바 응용프로그램만 실행
            자바 응프로그램이 시작될 때 jvm이 함께 실행됨
            자바 응용프로그램이 종료하면 jvm도 함계 종료함
        응용프로그램은 하나 이상의 스레드로 구성 가능


## 자바 스레드 만드기
    스레드 만드는 2가지 방법
        java.lang.Thread 클래스를 상속받아 스레드 작성
        java.lang.Runnable 인터페이스를 구현하여 스레드 작성


## Thread 클래스를 상속받아 스레드 만들기
    Thread를 상속받아 run() 오버라이딩
        Thread 클래스 상속, 새 클래스 작성
        run() 메소드 작성
            run() 메소드르 ㄹ스레드 코드라고 부름
            run() 메소드에서 스레드 실행 시작

    스레드 객체 생성
        새성된 객체는 필드와 메소드를 가진 객체일 뿐
        스레드로 작동하지 않음

    스레드 시작
        start()메소드 호출
            스레드로 작동 시작
            스레드 객체의 run()이 비로소 실행
            JVM에 의해 스케쥴되기 시작함


```java
import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread{
    private JLabel timerLabel;
    public TimerThread(JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }

    // 스레드 코드 , run()이 종료하면 스레드 종료
    @Override
    public void run() {
        int n=0; // 타이머 카운트 값
        while(true) { // 무한 루트
            timerLabel.setText(Integer.toString(n));
            n++; // 카운트 증가
            try {
                Thread.sleep(1000); // 1초 동안 잠을 잔다
            }
            catch(InterruptedException e) {return;}
        }
    }
}
public class ThreadTimerEx extends JFrame {
    public ThreadTimerEx() {
        setTitle("Thread를 상속받은 타이머 스레드 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        setSize(250, 150);
        setVisible(true);

        // 타이머 값을 출력할 레이블 생성
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 30));
        c.add(timerLabel);

        TimerThread th = new TimerThread(timerLabel);
        th.start(); // 타이머 스레드의 실행을 시작하게 한다
    }

    public static void main(String[] args) {
        new ThreadTimerEx();
    }
}
```


## Runnable 인테페이스로 스레드 만들기
    Runnable 인터페이스 구현하는 새 클래스 작성
        run() 메소드 구현
            run() 메소드를 스레드 코드라고 부름
            run() 메소드에서 스레드 실행 시작

    스레드 객체 생성

    스레드 시작
        start() 메소드 호출
            스레드로 작동 시작
            스레드 객체의 run()이 비로소 실행
            JVM에 의해 스케쥴되기 시작함

```java
import java.awt.*;
import javax.swing.*;

// class TimerThread extends Thread {
class TimerThread implements Runnable {   
    private JLabel timerLabel;
    public TimerThread(JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }

    // 스레드 코드 , run()이 종료하면 스레드 종료
    @Override
    public void run() {
        int n=0; // 타이머 카운트 값
        while(true) { // 무한 루트
            timerLabel.setText(Integer.toString(n));
            n++; // 카운트 증가
            try {
                Thread.sleep(1000); // 1초 동안 잠을 잔다
            }
            catch(InterruptedException e) {return;}
        }
    }
}
public class ThreadTimerEx extends JFrame {
    public ThreadTimerEx() {
        setTitle("Thread를 상속받은 타이머 스레드 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        setSize(250, 150);
        setVisible(true);

        // 타이머 값을 출력할 레이블 생성
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 30));
        c.add(timerLabel);

        // TimerThread th = new Thread(tirmerLabel);
        TimerThread runnable = new TimerThread(timerLabel);
        Thread th = new Thread(runnable);
        th.start(); // 타이머 스레드의 실행을 시작하게 한다
    }

    public static void main(String[] args) {
        new ThreadTimerEx();
    }
}
```


## main 스레드
    mian 스레드
        JVM이 응용프로그램을 실행할 때 디폴트로 생성되는 스레드
            main() 메소드 실행 시작
            main() 메소드가 종료하면 main 스레드 종료


## 스레드 종료와 타 스레드 강제 종료
    스스로 종료
        run() 메소드 리턴

    타 스레드에서 강제 종료
        interrupt() 메소드 사용


```java
// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class VibratingFrame extends JFrame implements Runnable {
    private Thread th;  // 진동하는 스레드
    public VibratingFrame() {
        setTitle("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocation(300, 300);
        setVisible(true);

        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!th.isAlive()) return;
                    th.interrupt();
            }
        });

        th = new Thread(this);  // 진동하는 스레드 객체 생성
        th. start();    // 진동 시작
    }
    @Override
    public void run() { // 프레임의 진동을 일으키기 위해
                    // 20ms마다 프레임의 위치를 랜덤하게 이동
        Random r = new Random();
        while (true) {
            try {
                Thread.sleep(20);   // 20ms 잠자기
            }
            catch(InterruptedException e){
                return; // 리턴하면 스레드 종료
            }
            int x = getX() + r.nextInt()%5;
            int y = getY() + r.nextInt()%5;
            setLocation(x, y);
        }
    }
    public static void main(String[] args) {
        new VibratingFrame();
    }    
}
```


## 스레드 동기화
    멀티스레드 프로그램 작성시 주의점
        다수의 스레드가 공유 데이터에 동시에 접근하는 경우
            공유 데이터의 값에 예상치 못한 결과 발생 가능

    스레드 동기화
        동기화란
            스레드 사이의 실행순서 제어, 공유데이터에 대한 접근을 원할하게 하는 기법
        멀티스레드의 공유 데이터의 동시 접근 문제 해결
            방법1) 공유 데이터를 접근하는 모든 스레드이 한줄 세우기
            방법2) 한 스레드가 공유 데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기 하도록 함
    
    자바의 스레드 동기화 방법 2가지
        synchronized 키워드로 동기화 블록 지정
        wait()-notify() 메소드로 스레드 실행 순서 제어


## synchronized 블록 지정
    synchronized 키워드
        스레드가 독점적으로 실행해야 하는 부분(동기화 코드)을 표시하는 키워드
            임제 영역 표기 키워드
        synchronized 블록 지정 방법
            메소드 전체 혹은 코드 블록
    
    synchronized 블록이 실행될 때
        먼저 실행한 스레드가 모니터 소유
            모니터란 해당 객체를 독점적으로 사용할 수 있는 권한
        모니터를 소유한 스레드가 모니터를 내놓을 때까지 다른 스레드 대기


## wait()-notify()를 이용한 스레드 동기화
    wait()-notify()가 필요한 경우
        공유 데이터로 두 개 이상의 스레드가 데이터를 주고 받을 때
            producer-consumer문제

    동기화 메소드 
        wait() : 다른 스레드가 notify()를 불러줄 때까지 기다린다
        notify() : wait()를 호출하여 대기중인 스레들ㄹ 꺠운다
            wait(), notify()는 Object의 메소드


## 



## 5월 31일
## 자바의 GUI 프로그래밍 방법
    자바의 GUI 프로그래밍 방법 2종류
        컴포넌트 기반 GUI 프로그래밍
            스윙 컴포넌트를 이용하여 쉽게 GUI를 구축
            자바에서 제공하는 컴포넌트의 한계를 벗어나지 못함

        그래픽 기반 GUI 프로그래밍
            그래픽을 이용하여 GUI 구축
            개발자가 직접 그래픽으로 화면을 구성하는 부단
            독특한 GUI를 구성할 수 있는 장점
            GUI 처리의 실행 속도가 빨라, 게임 등에 주로 이용

## 스윙 컴포넌트의 공통 메소드, JComponent의 메소드
    JComponent
        스윙 컴포넌트는 모두 상속받는 슈퍼 클래스, 추상 클래스
        스윙 컴포넌트들이 상속받는 공통 메소드와 상수 구현
        JComponent의 주요 메소드 사례

```java
//package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentEx extends JFrame{
    public JComponentEx() {
        super("JComponent의 공통 메소드 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton(" Disabled Button");
        JButton b3 = new JButton("getX(), getY()");
        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.MAGENTA);
        b1.setFont(new Font("Arial", Font.ITALIC, 20));
        b2.setEnabled(false);
        b3.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                setTitle(b.getX() + "," + b.getY());

            }
        });
        c.add(b1); c.add(b2); c.add(b3);
        setSize(20, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JComponentEx();
    }
}
```

## JLabel로 문자열과 이미지 출력
    JLabel의 용도
        문자열이나 이미지를 화면에 출력하기 위한 목적

## 레이블 생성 예
    문자열 레이블 생성 
        JLabel textLabel = new Jlabel("사랑합니다");
    
    이미지 레이블 생성
        이미지 파일로부터 이미지를 읽기 위해 Imagelcon 클래스 사용
        다룰 수 있는 이미지: png, gif, jpg 
        

    수평 정렬 값을 가진 레이블 컴포넌트 생성
        수평 정렬로, 문자열과 이미지를 모두 가진 레이블

## 이미지 버튼 만들기
    하나의 버튼에 3개의 이미지 등록
        마우스 조작에 따라 3개의 이미지 중 적절한 이미지 자동 출력
    
    3개의 버튼 이미지
        normallcon
            버튼의 보통 상태(디폴트) 때 출력되는 이미지
            생성자에 이미지 아이콘 전달 혹은 JButton의 setIcon(normalIcon);
        
        rollonerIcon
            버튼에 마우스가 올라갈 때 출력되는 이미지
            이미지 설정 메소드: JButton의 setR0oolloverIcon(rolloverIcon);

        pressdIcon
            버튼을 누른 상태 때 출력되는 이미지
            이미지 설정 메소드 : JButton의 setPressedIcon(preddedIcon)

```java
//package chapter02;

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
```

## JCheckBox로 체크박스 만들기
    JCeckBox의 용도
        선택과 비선택 두 상태만 가지는 버튼

```java
package chapter02;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame{
    public CheckBoxEx() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon gosling = new ImageIcon("image/gosling.jpg");

        // 3개의 체크박스 생성
        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        JCheckBox cherry = new JCheckBox(gosling);
        JCheckBox foo = new JCheckBox("고슬링", gosling, true);

        c.add(apple);
        c.add(pear);
        c.add(cherry);
        c.add(foo);

        setSize(250, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckBoxEx();
    }
}
```

## 체크박스에 Item 이벤트 처리
    Item 이벤트
        체크 박스의 선택 상태에 변화가 생길 때 발생하는 이벤트
            사용자가 마우스나 키보드로 체크박스 선택/해체할 때
            프로그램에서 체크박스를 선택/해체하여 체크 상태에 변화가 생길 때
        이벤트가 발생하면 ItemEvent 객체 생성
        ItemListener 리스너를 이용하여 이벤트 처리
    ItemListener 리스너의 추상 메소드
        void itemStateChanged(ItemEvnet e)

    ItemEvent의 주요 메소드
        int getStateChange()
        Object getItem()

## RadioButton으로 라디오버튼 만들기
    JRadioButton의 용도
        버튼 그룹을 형성하고, 그룹에 속한 버튼 중 하나만 선택되는 라디오버튼
        체크박스와의 차이점
            체크 박스는 각가 선택/해체가 가능하지만, 라디오버튼은 그룹에 속한 버튼 중 하나만 선택

## 라디오 버튼 생성 및 Item 이벤트 처리
    버튼 그룹과 라디오 버튼 생성 과정
        1. 버튼 그룹 객체 생성
        2.라디오버튼 생성
        3. 라디오버튼을 버튼 그룹에 삽입
        4. 라딩버튼을 컨테이너에 삽입
    라디오 버튼에 Item 이벤트 처리 : ItemListener 리스너 이용
        라디오버튼이 선택/해체되어 상태가 달라지면, Item 이벤트 발생
            사용자가 마우스나 키보드로 선택 상태를 변경 할 때
            프로그램에서 JRadioButton의 setSelected()를 호출하여 선택 상태를 변경할 때

```java
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
```

## JTextField로 한 줄 입력 창 만들기
    JTextField
        한 줄의 문자열을 입력 받는 창(텍스트필드)
            텍스트 입력 도중 엔터키가 입력되면 Action 이벤트 발생
            입력 가능한 문자 개수와 입력 창의 크기는 서로 다름


```java
TextFieldEx.java
```

```java
TextAreaEx.java
```

## JList<E>
    JList<E>
        하나 이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트
        Java 7부터 제네릭 리스트로 바뀜
            <E>에 지정된 타입의 객체만 저장하는 리스트
        JScrollPane에 JList<E>를 삽입하여 스크롤 가능
    
```java
listEx.java
```

## JCombobox<E>
    JCombobox<E>
        텍스트필드와 버튼, 그리고 드롭다운 리스트로 구성되는 콤보박스
        드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남

```java
ComboActionEx.java
```

## 메뉴 구성
    메뉴 만들기에 피룡한 스윙 컴포넌트
        메뉴아이템 - JMenuItem
        메뉴 - JMenu
            여러 개의 메뉴 아이템을 가짐
        메뉴바 - JMenuBar
            여러 개의 메뉴를 붙이는 바이며, 프레임에 부착됨
        분리선
            메뉴아이템 사이의 분리선으로 separator라고 부름
            JMenu의 addSeparator()를 호출하여 삽입함

```java
MenuEx.java
```

## 메뉴아이템에 Action 이벤트 달기
    메뉴아이템을 클릭하면 Action 발생
        메뉴아이템은 사용자로부터 지시나 명령을 받는데 사용
        ActionListener 인터페이스로 리스너 작성
        각 메뉴아이템마다 이베느 리스너 설정

```java
MenuActionEventEx.java
```

## 팝업 다이얼로그, JOptuonPane
    팝업 다이얼로그
        사용자에게 메세지를 전달하거나 문자열을 간단히 입력받느 ㄴ용도
        JOptionPane 클래스를 이용하여 생성
            static 타입의 간단한 메소드 이용
    
    입력 다이얼로그 - JOptionPane.showInputDialog()
        한 줄을 입력 받는 다이얼로그

## 확인 다이얼로그
    확인 다이얼로그 -JoptionPane.ShowConfirmDialog()



## 5월 24일
## 이벤트 기반 프로그래밍
    이벤트 기반 프로그래밍
        이벤트의 발생에 의해 프로그램 프름이 결정되는 방식
            이벤트가 발생하면 이벤트를 처리하는 루틴(이벤트 리스너) 실행
            실행될 코드는 이벤트의 발생에 의해 전적으로 결정
        반대되는 개념 : 배치 실행
            프로그램의 개발자가 프로그램이 흐름을 결정하는 방식
        이벤트 종류
            사용자의 입력 : 마우스 드래그, 마우스 클릭, 키보드 누름 등
            센서로부터의 입력, 네트워크ㅗ부터 데이터 송수신
            다른 응요프로그램이나 다른 스레드로부터의 메세지
    이벤트 기반 응용 프로그램의 구조
        각이벤트마다 처리하는 리스너 코드 보유
    GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
        GUI 라이브러리 종류
            C++ 의 MFC, C#, GUI, Visual Basic, X Window, Android 등
            자바의 AWT와 Swing

## 자바 스윙 프로그램에서 이벤트 처리 과정
    이벤트가 처리되느 ㄴ과정
        이벤트 발생
            예 : 마우스의 움직임 혹은 키보드 입력
        이벤트 객체 생성
            현재 발생한 이벤트에 대한 저보를 가진 객체
        응용프로그램에 작성된 이벤트 리스너 찾기
        이벤트 리스너 실행
            리스너에 이벤트 객체 전달
            리스너 코드 실행
    
## 이벤트 객체
    이벤트 객체
        발생한 이벤트에 관한 정보를 가진 객체
        이벤트 리스너에 전달됨
            이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 하악할 수 있게 함
    
    이벤트 객체가 포함하는 정보
        이벤트 종류와 이벤트 소스
        이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
        이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
        클릭된 마우스 버튼 번호 및 마우스이 클릭 횟수
        키의 코드 값과 문자 값
        체크박스, 라디오버튼 등과 같ㅌ은 컴포넌트에 이벤트가 발생하였다면 체크 상태

    이벤트 소스를 알아 내는 메소드
        Oject getSource()
            발생한 이벤트의 소스 컴포넌트 리턴
            Object 타입으로 리턴하므로 캐스팅하여 사용
            모든 이벤트 객체에 대해 적용
    
## 리스너 인터페이스
    이벤트 리스너
        이벤트를 처리하는 자바 프로그램 코드, 클래스로 작성
    자바는 다양한 리스너 인테페이스 제공

    사용자의 이벤트 리스너 작성
        자바의 리스너 인터페이스 (interface)를 상속받아 구현
        리스너 인터페이스의 모든 추상 메소드 구현

## 이벤트 리스너 작성 과정 사례
    1. 이벤트와 이벤트 리스너 선택
        버튼 클릭을 처리하고자 하는 경우
            이벤트 : Action 이벤트, 이벤트 리스너 : ActionListener
    2. 이벤트 리스너 클랙스 작성 : ActionListener 인터페이스 구현

    ```java
        class MyActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
            }
        }
    ```

    3. 이벤ㅌ 리스너 등록
        이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
        component.addXXXListener(listener)
            xxx : 이벤트 명, listener : 이벤트 리스너 객체

## 이벤트 리스너 작성 방법
    3 가지 방법
        1.독립 클래스로 작성
            이벤트 리스너를 완전한 클래스로 작성
            이베트 리스너를 여러 곳에서 사용할 때 적합
        2.내부 클래스(inner class)로 작성
            클래스 안에 맴버처럼 클래스 작성
            이벤트 리스너를 특정 클래스에서만 사용할 때 적합
        3.익명 클래스(anonymous class)로 작성
            클래스의 이름 없이 간단히 리스너 작성
            클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합

```java
//package chapter02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndepClassListener extends JFrame {
    public IndepClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);
        setSize(250, 120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new IndepClassListener();
    }
}
//독립된 클래스로 이벤트 리스너를 작성한다.
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action"))
            b.setText("액션");
        else
            b.setText("Action");
    }
}
```

## 익명 클래스로 이벤트 리스너 작성
    익명 클래스 : 이름 없는 클래스
        ( 클래스 선언 + 인스턴스 생성)을 한번에 달성
        간단한 리스너의 경우 익명 클래스 사용추천
            메소드의 개수가 1, 2개인 리스너에 대해 주로 사용

```java
//package chapter02;

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
```
## 어뎁터 클래스
    이벤트 리스너 구현에 따른 부담
        리스너의 추상 메소드를 모두 구현해야 하는 부담
        예) 마우스 리스너에서 마우스가 눌러지는 경우(mousePressed)만 처리하고자 하는 경우에도 나머지 4개의 메소드를 모두 구현해야 하는 부담
    어뎁터 클래스(Adpter)
        리스너의 모든 메소드를 단순 리턴하도록 만든 클래스(JDK에서 제공)
        추상 메소드가 하나뿐인 리스너는 어댑터 없음
            ActionAdapter, ItemAdapter 클래스는 존재하지 않음

## Key 이벤트와 포커스
    키 입력 시, 다음 세 경우 각각 key 이벤트 발생
        키를 누르는 순간
        누른 키를 떼는 순간
        누른 키를 떼는 순간(Unicode 키의 경우에만)
    키 이벤트를 받을 수 있는 조건
        모든 컴포넌트
        편재 포커스를 가지 컴포넌트가 키 이벤트 독점
    포커스
        컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
        컴포넌트에 포커스 설정 방법 : 다음 2 라인 코드 필요
            commonent.setFcousable(true); // commonent가 포커스를 받을 수 있도록 설정
            component.requesFocus(); // commonent에 포커스 강제 지정

## keyListener
    응용프로그램에서 keyListener를 상속받아 ㅣ 리스너 구현
    keyListener의 3개의 메소드
        키를 누르는 순간
        누른 키를 떼는 순간
        누른 키를 떼는 순간 Unicode 키가 경우
    컴포넌트 키 이베트 키스너 달기

## 유니코드 키
    유니코드 키의 특징
        국제 산업 표준
        전세계의 문자를 컴퓨터에서 일과되게 표현하기 위한 코드 체계
        문자들에 대해서만 키 코드 값 정의
        문자들가 아닌 키 겨웅에는 표준화된 키 코드 값 없음
    
    유니코드 키가 입력되는 경우
        keyPressed(), keyTyped(), keyReleased() 가 순서대로 호출
    유니코드 키가 아닌 경우
        keyPressed(), keyReleased() 만 호출됨

## 가상 키와 입력된 키 판별
    keyEvent 객체 
        입력된 키 정보를 가진 이벤트 객체
        keyEvnet 객체의 메소드로 입력된 키 판별
    keyEvent 객체의 메소드로 입력된 키 판별
        char keyEvnetgetKeyChar()
            키의 유니코드 문자 값 리턴
            Unicode 문자 키인 경우에만 의미 있음
            입력된 키를 판별하기 위해 문자값과 비교하면 됨

        int keyEventgetCode()
            유니코드 키 포함
            모든 키에 대한 정수형 키코드 리턴
            입력된 키를 판별하기 위해 가상키 갑과 비교하여야 함
            가상 키 값은 ketEvent 클래스에 상수로 선언

```java
//package chapter02;

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
```

## 마우스 리스너 달기와 MouseEvent 객체 활용
    마우스 리스너 달기
        마우스 리스너는 컴포넌트에 다음과 같이 등록
        컴포넌트가 마우스 무브나 마우스 드래킹을 함께 처리하고자 하며나, MouseMotion 리스너 따로 등록
    
    MouseEvent 객체 활용
        마우스 포인터의 위치, 컴포넌트 내 상대 위치
            int DetX(), int getY()

        마우스 클릭 횟수
            int getClickCount()


## 5월 17일
## 배치 관리사 대표 유형 4가지
    FlowLayout 배치관리자
        컴포넌트가 삽임되는 순서대로 인쪽에서 오른쪽으로 배치
        배치할 공간이 없으면 아래로 내려와서 바복한다
    BorderLayout 배치관리자
        컨테이너의 공간을 동, 서, 남, 북, 중앙의 5개 영역으로 나눔
    GridLayout 배치관리자
        컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔
        컴포넌트는 삽임 순서대로 좌에서 우로, 다시 위에서 아래로 배치
    CardLayout
        컨테이너의 공간에 카드를 쌓아 놓은 듯이 컴포넌트를 포개어 배치

## 컨테이너의 디폴트 배치관리자
    컨테이너 생성시 자동으로 생성되는 배치관리자

    AWT와 스윙 컨테이너 Window, JWindow, Frame, JFrame, Dialog, JDialog 의 디폴트 배치 관리자는 BorderLayout
    AWT와 스윙 컨테이너 Panel, JPanel, Applet, JApplet 의 디폴트 배치관리자 FlowLayout

## 컨테이너의 새로운 배치관리자 설정
    컨테이너에 새로운 배치관리자 설정
        setLayout(LayoutManager Im) 메소드 호출
            Im을 새로운 배치관리자로 설정

## FlowLayout 배치관리자
    배치방법
        컴포넌트를 컨테이너 내에 왼쪽에서 오른쪽으로 배치
            다시 위에서 아래로 순서대로 배치

## FlowLayout의 생성자
    생성자
        FlowLayout()
        FlowLayout(int align, int hGap, int vGap)
            align : 컴포넌트를 정렬하는 방법 지정, 왼쪽 정렬, 오른쪽 정렬, 중앙 정렬
            hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위, 디폴트는 5
            vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위, 디폴트는 5

## 스윙 응용프로그램의 종료
    응용프로그램 내에서 스스로 종료하는 방법
        System.exit(0);
            언제 어디서나 무조건 종료

    프레임의 오른쪽 사단의 종료버튼(X)이 클릭되면 어던 일이 일어나는가?
        프레임 종료, 프레임 위도우를 닫음
            프레임이 화면에서 보이지 않게 됨
        프레임이 보이지 않게 되지만 응용프로그램이 종료한 것 아님
            키보드나 마우스 입력을 받지 못함
            다시 setVisivle(true)를 보충하면, 보이게 되고 이전 처럼 작동함
    
    프레임 종료 버튼이 클릭 될 때, 프레임과 함께 프로그램을 종료 시키는 방법
        frame.setDefaultCloseOpaeration(JFrame.EXIT_ON_CLOSE);

```java
package chapter02;
import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame{
    public FlowLayoutEx() {
        setTitle("FlowLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); //컨탠트팬 알아내기

        // 왼쪽 정렬로, 술평 간격을 30, 수직 간격을 40 픽셀로 배치하는
        // FlowLayout 생성
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30 , 40));

        contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300, 200); //프레임 크기 300x200 설정
        setVisible(true); // 화면에 프레임 출력
    }

    public static void main(String[] args) {
        new FlowLayoutEx();
    }
}
```

## BorderLayout 배치관리자
    배치방법
        컨테이너 공간을 5 구역으로 분할, 배치
            동, 서, 남, 북, 중앙
        배치 방법
            add(Component comp, int index)
                comp를  index의 공간에 배치

## BorderLayout 생성자와 add() 메소드
    생성자
        BorderLayout()
        BorderLayout(int hGap, int vGap)
            hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0 )
            vGap : 상하 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0 )
    
    add() 메소드
        void add(Component comp, int index)
            comp 컴포넌트를 index 위치에 삽입한다.
            index : 컴포넌트의 위치
                동 : BorderLayout.EAST 서 : BorderLayout.WEST 남 : BorderLayout.SOUTH 북 : BorderLayout.NORTH 중앙 : BorderLayout.CENTER

```java
package chapter02;
import javax.swing.*;
import java.awt.*;

public class BoderLayoutEx extends JFrame{
    public BoderLayoutEx() {
        setTitle("BoderLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); //컨탠트팬 알아내기

        // 컴팬트팬에 BoderLayout 배치관리자 생성
        contentPane.setLayout(new BorderLayout());

        contentPane.add(new JButton("Calculate"), BorderLayout.CENTER);
        contentPane.add(new JButton("add"), BorderLayout.NORTH);
        contentPane.add(new JButton("sub"), BorderLayout.SOUTH);
        contentPane.add(new JButton("mul"), BorderLayout.EAST);
        contentPane.add(new JButton("div"), BorderLayout.WEST);

        setSize(300, 200); //프레임 크기 300x200 설정
        setVisible(true); // 프레임을 화면에 출력
    }

    public static void main(String[] args) {
        new BoderLayoutEx();
    }
}
```

## GridLayout 배치관리자
    배치방법
        컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 컴포넌트 하나씩 배치
            생성자에 행수와 열수 지정
            셀에 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치

## GridLayout 생성자
    생성자
        GridLayout()
        GridLayout(int rows, int clos)
        GridLayout(int rows, int clos, int hGap, int vGap)
            rows : 격자의 행수 (디폴트 : 1)
            cols : 격자의 열수 (디폴트 : 1)
            hGap : 좌우 두 컴포넌트 사이의 수평 간격, 픽셀 단위(디폴트 : 0)
            vGap : 상하 두 컴포넌트 사이의 수직 간격, 픽셀 단위(디폴트 : 0)
            rows X cols 만큼의 셀을 가진 격자로 컨테이너 공간을 분할, 배치


```java
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
```

## 배치관리자 없는 컨테이너
    배치관리자가 없는 컨테이너가 필요한 경우
        응용프로그램에서 직접 컴포넌트의 크기와 위치를 결정하고자 하는 경우
            1. 컴포넌트의 크기나 위치를 개발자 임의로 결정하고자 하는 경우
            2. 게임 프로그램과 가이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우
            3. 여러 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우

    컨테이너의 배치 관리자 제거 방법
        container.setLayout(null);

        컨테니어의 배치관리자가 없어지면, 컴포넌트에 대한 어떤 배치도 없음
            추가된 컴포넌트의 크기가 0으로 설정, 위치는 예측할 수 없게 됨

## 컴포넌트의 절대 위치와 크기 설정
    배치관리자가 없는 컨테이너에 컴포넌트를 삽입할 때
        프로그램에서 컴포넌트의 절대 크기와 위치 설정
        컴포넌트들이 서로 겹치게 할 수 있음

    컴포넌트의 크기와 위치 설정 메소드
        void setSize(int width, int height)             // 컴포넌트 크기 설정
        void setLocation(int x, int y)                  // 컴포넌트 위치 설정
        void setBounds(int x, int width, int height)    // 위치와 크기 동시 설정



## 5월 3일 강의(중간 이후)
## 컬렉션의 개념
    요소라고 불리는 가벼 개수의 객체들의 저장소
        객체들의 컨테이너라고도 불림
        요소의 개수에 따라 크기 자동 조절
        요소의 삽입, 삭제에 따른 요소의 위치 자동 이동
    고정 크기의 배열을 다루는 어려움 해소
    다양한 객체들의 삽입, 삭제 검색 등의 관리 용이

## 컬렉션의 특징
    1. 컬렉션은 제네릭 기법으로 구현
        제네릭
            특정 타입만 다루지 않고, 여러 종류의 타입으로 변신할 수 있도록 클래스나 메소드를 일반화시키는 기법
            클래스나 인터페이스 이름에 <E>,<K>,<V> 등 타입매개변수 포함
        제네릭 컬렉션 사례 : 벡터 Vextor<E>
            <E>에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
            정수만 다루는 컬렉션 벡터 Vextor<Integer>
            문자열만 다루는 컬렉션 벡터 Vector<String>
    
    2. 컬렉션의 요소는 객체만 가능
        int, char, oduble 등의 기본 타입으로 구체화 불가

## 제네릭은 형판과 같은 개념
    제네릭
        클래스나 메소드를 형판에서 찍어내듯이 생산할 수 있도록 일반화된 평판을 만드는 기법
    
## Vector<E>
    벡터 Vector<E>의 특성
        <E>에 사용할 요소의 특정 타입으로 구체화
        배열을 가변 크기로 다룰 수 있게 하는 커네이너
            배열의 길이 제한 극복
            요소의 개수가 넘치면 자동으로 길이 조절
        요소 객체들을 삽입,삭제, 검색하는 컨테이너
            삽입, 삭제에 따라 자동으로 요소의 위치 조정
        Vector에 삽입 가능한 것
            객체, null
            기본 타입의 값은 Wrapper 객체로 만들어 저장
        Vector에 객체 삽입
            벡터의 맨 뒤, 중간에 객체 삽입 가능
        Vector에서 객체 삭제
            임의의 위치에 있는 객체 삭제 가능

## 컬렉션과 자동 박싱/언박싱
    JDK 1.5 이전
        기본 타입 데이터를 Wrapper 객체로 만들어 삽입
        컬렉션으로부터요소를 얻올 때, Wrapper 클래스로 캐스팅 필요
    
    JDK 1.5 부터
    자동 박싱/언박싱이 작동하여 기본 타입 값 삽입 가능

## 컬렉션 생성문의 진화 : Java 7, Java 10
    Java 7 이전
        Vector<Integer> v = new Vector<Integer>(); // Java 7 이전

    Java 7 이후
        컴파일러의 타입 추론 기능 추가
        <>(다이어몬드 연사자)에 타입 매개변수 생략
        Vector<Integer> v = new Vector<>(); // Java 7부터 추가, 가능
        
    Java 10 이후
        var 키워드 도입, 컴파일러의 지역 변수 타입 추론 가능
        var v = new Vector<Integer>(); // Java 10부터 추가, 가능

``` java
package chapter02;

import java.util.Vector;

public class VectorEx {
    public static void main(String[] args) {
        // 정수 값만 다루는 제네릭 벡터 생성
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);   // 5 삽입
        v.add(4);   // 4 삽입
        v.add(-1);   // -1 삽입

        // 벡터 중간에 삽입하기
        v.add(2, 100); // 4와 -1 사이에 정수 100 삽입
        System.out.println("베거 내의 요소 객체 수 : " + v.size());
        System.out.println("벡터의 현재 용량 : " + v.capacity());

        // 모든 요소 저수 출력하기
        for (int i = 0; i < v.size(); i++) {
            int n = v.get(i);   // 벡터의 1 번째 정수
            System.out.println(n);            
        }
        // 벡터 속의 모든 정수 더하기
        int sum = 0;
        for(int i=0; i<v.size(); i++)   {
            int n = v.elementAt(); // 벡터의 1 번째 정수
            sum += n;
        }
        System.out.println("벡터에 있는 함수 합 : " + sum);
    }    
}

```

## ArrayList<E>
    가변 크기 배열을 구현한 클래스
        <E>에 요소로 사용할 특정 타입으로 구체화
    벡터와 거의 동일
        요소 삽입, 삭제, 검색 등 벡터 기능과 거의 동일
        벡터와 달리 스레드 동기화 기능 없음
            다수 스레드가 동시에 ArrayList에 접근할 때 동기화되지 않음. 개발자가 스레드 동기화 코드 작성

## 컬렉션의 순차 검색을 위한 Iterator
    Iterator<E> 인터페이스
        리스트 구조의 컬렉션에서 요소의 순차 검색을 위한 인터페이스
            Vector<E>, ArrayList<E>, LinkedList<E>가 상속받는 인터페이스

    Iterator 객체 얻어내기
        컬렉션의 Iterator()메소드 호출
            해당 컬렉션을 순차 검색할 수 있는 Iterator 객체 리턴
        컬렉션 검색 코드

## HashMap <K, V>
    키(Key)와 값(value)의 쌍으로 구성되는 요소를 다루는 컬렉션
        K : 키로 사용할 요소의 타입
        V : 값으로 사용할 요소의 타입
        키와 값이 한 쌍으로 삽입
        '값'을 검색하기 위해서는 반드시 '키' 이용
    삽입 및 검색이 빠른 특징
        요소 삽입 : put() 메소드
        요소 검색 : get() 메소드

```java
package chapter02;
import java.util.*;
public class HavhMapDicEx {
    public static void main(String[] args) {
        // 영어 단어와 한글 단어의 쌍을 저장하는 HashMap
        HashMap<String, String> dic = new HashMap<String, String>();

        // 3 개의 (key, value) 쌍을 dic에 저장
        dic.put("baby", "아기");
        dic.put("love", "사랑");
        dic.put("apple", "사과");

        // dic 해시 맵에 들어 있는 모든 (key, value) 쌍 출력
        Set<String> keys = dic.keySet(); // 모든 키를 Set 컬렉션에 받아옴
        Iterator<String> it = keys.iterator(); // Set에 접근하는 Iterator 리턴
        while(it.hasNexst()) {
            String key = it.next(); // 키
            String value = dic.get(key); // 값
            System.out.print("(" + key + "," + value + ")");
        }
        System.out.println();

        // 영어 단어를 입력받고 한글 단어 검색
        Scanner scanner = new scanner(System.ln);
        for(int i=0; i<3; i++) {
            System.out.print("찾고 싶은 단어는?");
            String eng = scanner.next();
            // 해시맵에서 '키' eng의 '값' kor 검색
            if(kor == null)
                System.out.println(eng + "는 없는 단어 입니다.");
            else
                System.out.println(kor);
        }
    }
}
```

## 제네릭 만들기
    제네릭 클래스 작성
        클래스 이름 옆에 일반화된 타입 매개 변수 추가
        제네릭 객체 생성 미 활용
            제네릭 타입에 구체적인 타입을 지정하여 객체를 생성하는 것을 구체화라고 함

## 자바의 GUI(Sraphical User InterFace)
    GUI 응용프로그램
        GUI
            사용자가 편리하게 입출력 할 수 잇도록 그래픽으로 화면을 구성하고, 마우스나 키보드로 입력 받을 수 있돌고 지원하는 사용자 인터페이스
        자바 언어에서 GUI 응용프로그램 작성
            AWT 와Swing 패키지에 강력한 GUI 컴포넌트 제공
            쉬운 GUI 프로그래밍
    
    AWT와 Swing 패키지
        AWT(Abstract windowing Toolkit) 패키지
            자바가 음 나았을 때부터 배포된 GUI 패키지, 최근에는 거의 사용하지 않음
            AWT 컴포넌트는 중량 컴포넌트(heavy weight component)
                AWT 컴포넌트의 그리기는 운영체제에 의해 이루어지며, 운영체제에 의 자원을 많이 소모하고 부담을 줌
                운영체제가 직접 그리기 때문에 속도는 빠름
        
        Swing패키지
            AWT 기술을 기반으로 작성된 자바 라이브러리
            모든 AWT 기능 + 추가된 풍부하고 화려한 고급 컴포넌트
            AWT 컴포넌트를 모두 수윙으로 재작성, AWT 컴포넌트 이름 앞에 J자를 덧 붙임
            순수 자바 언어로 구현
            스윙 컴포넌트는 경량 컴포넌트
                스윙 컴포넌트는 운영체제의 도움을 받지않고 직접 그리기 대문에 운영체제에 부담주지 않음
            현재 바다의 GUI로 사용됨

## 컨테이너와 컴포넌트
    컨테이너
        다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트
            java.awt.Container를 상속받음
        다른 커네이너에 포함될 수 있음
            AWT 컨테이너 : Panel, Frame, Applet, Dialog, Window
            Swing 컨테이너 : JPanel, JFrame, JApplet, JWindow

    컴포넌트
        컨테이너에 포함되어야 화면에 출력될 수 있는 GUI 객체
        다른 컴포넌트를 포함할 수 없는 순수 컴포넌트
        모든 GUI 컴포넌트가 상속받는 클래스 : java.awt.Component
        스윙 컴포넌트가 상속받는 클래스 : javax.swing.JComponent
    
    최상위 컨테이너
        다른 컨테이너에 포함도지 않고도 화면에 출력되며 독립적으로 존재 가능한 컨테이너
            스스로 화면에 자신을 출력하는 컨테이너 : JFrame, JDialog, JApplet


## 스윙 GUI 프로그램 만들기
    스윙 GUI 프로그램을 만드는 과정
        1. 스윙 프레임 만들기
        2. MAIN() 메소드 작성
        3. 스윙 프레임에 스윙 컴포넌트 붙이기

    스윙 플그램 작서에 필요한 import문
        import java.awt.*;              // 그래픽 처리를 위한 크랠스들이 경로명
        import java.awt.event.*;        // AWT 이벤트 사용을 위한 경로명
        import java.swing.*;            // 스윙 컴포넌트 클래스들의 경로명
        import java.swing.event.*;      // 스윙 이벤트를 위한 경로명

## 스윙 프레임
    스윙 프레임 : 모든 스윙 컴포넌트를 담는 최상위 컨테이너
        JFrame을 상속받아 구현
        컴포넌트들은 화면에 보이려면 스윙 프레임에 부착되어야 함
            프레임을 닫ㅇ면 프레임에 부착된 모든 컴포넌트가 보이지 않게 됨
    스윙 프레임 기본 구성
        프레임 - 스윙 프로그램의 기본 틀
        메뉴바 - 메뉴들이 부착되는 공간
        컨펜트팬 - AUI 컴포넌트들이 부착되는 공간

## 프레임 만들기, JFrame 클래스 상속
    스윙 프레임
        JFrame 클래스를 상속받은 클래스 작성
        프레임의 크기 반드시 지정 : setSize() 호출
        프레임을 화면에 출력하느 ㄴ코드 반드시 필요 : setVisible(true) 호출

```java
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
```

## 스윙 응용프로그램에서 main()의 기능과 위치
    스윙 응용프로그램이 실행되는 시작점으로서의 기능만
    스윙 프레임을 생성하는 정도의 코드로 최소화

## 프레임에 컴포넌트 붙이기
    타이틀 달기
        super()나 setTitle() 이용
    
    컨텐트팬에 컴포넌트 달기
        컨텐트팬이란?
            스윙 컴포넌트들이 부착되는 공간
        
        컨텐트팬 알아내기
            스윙 프레임에 붙은 디폴트 컨텐트팬 알아내기

        컨텐트팬에 컴포넌트 붙이기

        컨텐트팬 변경

```java
package chapter02;
import javax.swing.*;
import java.awt.*;
public class ContentPaneEx extends JFrame {
    public ContentPaneEx() {
        setTitle("ContentPane과 JKrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());


        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300 ,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ContentPaneEx();
    }
}
```



## 4월 19일 강의
## 추상 클래스 상속
    추상 클래스를 상속받으면 추상 클래스가 됨
    서브 클래스도 abstract로 선언해야 함

## 추상 클래스 구현
    서브 클래스에서 슈퍼 클래스의 추상 메소드 구현(오버라이딩)
    추상 클래스를 구현한 서브 클래스는 추상 클래스 아님

## 추상 클래스 목적
    상속을 위한 슈퍼 클래스로 활용하는 것
    서브 클래스에서 추상 메소드 구현
    다형성 실현

추상 클래스 Calculator를 상속받는 goodCalc 클래스를 구현하라
```
abstract class Calculator {
    public abstract int add(int a, int b);
    public abstract int substract(int a, int b);
    public abstract int double average(int[] a);
}
```

## 자바의 인터페이스
자바의 인터헤이스 
    크랠스가 수현해야 할 메소듣이 선언되는 추상형
    인터페이스 선언
        inerface 키워드로 선언
자바 인터페이스에 대한 변화
    java 7까지
        인터페이스는 상수와 추상 메소드로만 구성
    java 8부터
        상수와 추상메소드 포함
        default 메소드 포함 (java 8)
        private 메소드 포함 (java 9)
        static 메소드 포함 (java 9)


## 인터페이스의 구성 요소들의 특징
상수
    public만 허용, public static final 생략
추상 메소드
    public abctract 생략 가능
default 메소드
    인터페이스에 코드가 작성된 메소드
    인터페이스를 구현하는 클래스에 자동 상속
    public 접근 지정만 허용, 생략 가능
private 메소드
    인터페이스 내에 메소드 코드가 작성되어야 함
    인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능
static 메소드
    public, private 모두 지정 가능, 생략하면 public


## 인터페이스 상속
인터페이스 간에 상속 가능
    인터페이스를 상혹하여 확장된 인터페이스 작성 가능
    extends 키워드로 상속 선언
인터페이스 다중 상속 허용


## 패키지 개념과 필요성
3명이 분담하여 자바 응용프로그램응ㄹ 개발하는 경우,
동일한 이름의 클래스가 존재할 가능성 있음
    ->합칠 때 오류 발생 가능성
    ->개발자가 서로 다른 디렉터리로 코드 관리하여 해결


## 자바의 패키지와 모듈이란?
패키지(package)
    서로 관련된 클래스와 인터페이스를 컴파일한 클래스 파일들을 묶어 놓은 디렉터리
    하나의 응용프로그램은 한 개 이상의 패키지로 작성
    패키지는 jar 파일로 압축할 수 있음
모듈(mobule)
    여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    하나의 모듈을 하나의 .jmod 파일에 저장
Java 9부터 모듈화 도입
    플랫폼의 모듈화
        java 9부터 자바 API의 ㅣ모든 클래스들(자바 실행 환경)을 패키지 기반에서 모듈들로 완전히 재구성
    응용프로그램의 모듈화
        클래스들은 패키지로 만들고, 다시 패키지를 모듈로 만듦
        모듈 프로그래밍은 어렵고 복잡, 기존 방식으로 프로그램 작성


## 자바 모듈화의 목적
모듈화의 목적
    java 9부터 자바 API를 여러 모듈(99개)로 분할
        java 8까지는 rt.jar의 한 파일에 모든 API 저장
    응용프로그램이 실행할 때 꼭필요한 모듈들로만 실행 환경 구축
        메모리 자원이 열안한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 실행 이미지를 만들기 위함

모듈의 현실
    java 9부터 전면적으로 도입
    복잡한 개념
    큰 자바 응용프로그램에는 개발, 유지보수 등에 적합
    현실적으로 모듈로 나누어 자바 프로그램을 작성할 필요 없음


## 자바 API이 모듈 파일들
자바 DK에 제공되는 모듈 파일들
    자바가 설치된 jmods 디렉터리에 모듈 파일 존재
        .jmod 확자자를 가진 파일
        모듈은 수십개
        모듈 파일은 ZIP 포팻으로 압축된 파일
    모듈 파일에는 자바 API의 패키지와 클래스들이 들어 있음
    jmod 명령을 이용하여 모듈 파일에 들어 있는 파키지를 풀어 낼 수 있음


## 패키지 사용하기, import문
다른 패키지에 작성된 클래스 사용
    import를 이용하지않는 경우
    필요한 클래스만 import
    패키지 전체를 import

## 패키지 만들기
클래스 파일(.class)이 저장되는 위치는?
    클래스나 인터페이스가 컴파일되면 클래스파일(.class) 생성
    클래스 파일은 패키지로 선언된 디렉터리에 저장
패키지 선언
    소스 파일의 맨 앞에 컴파일 후 저장될 패키지 지정


## 디포트 패키지
package 선언문이 없는 자바 소스 파일의 경우
    컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속시킴
    디폴트 패키지
        현재 디렉터리


## 모듈 개념
모듈
    java 9에서 도입된 개념
    패키ㅣ지와 이미 등의 리소스를 담은 컨테이너
    모듈 파일(.jmod)로 저장


## 자바 플랫폼의 모듈화
자바 플랫폼
    자바의 개발 환경(JDK)과 자바의 실행 환경(JRE)을 지칭
        java SE(자바 API) 포함
    자바 API이 모든 클래스 여러 개의 모듈로 재구성됨
    모듈 파일은 JDK의 jmods 디렉터리에 저장하여 베포
모듈 파일로붜 모듈을 푸는 명령


## 모듈 기반의 자바 실행 환경
자바 실행 환경
    JRE: 디폴트 자바 실행 환경


## 자바 모듈화의 목적
가장 큰 목적
    자바 컴포넌트들을 필요에 따라 조립하여사용하기 위함
    컴퓨터 시스템의 불필요한 부담 감소
        세밀한 모듈화를 통해 필요 없는 모듈이 로드되지 않게 함
        소형 IoT 장치에도 자바 응용프로그램이 실행되고 성능을 유지하게 함


## JDK
java.lang
    스트링 수학 함수,  입출력 등
java.util
    잘짜, 시간, 벡터, 헤시맵 등
java.io
    키보드, 모니터, 프린터, 디스크 등
java.awt
    GUI 프로그램을 작성하기 위한 AWT 패키지
java.swing
    GUI 프로그래밍을 작성하기 위한 스윙 패키지


## object 클래스
특징
    모든 자바 클래스는 반드시 object를 상속받도록 자동 컴파일
        모든 클래스의 슈퍼 클래스
        모든 클래스가 상속받는 공통 메소드 포함
    주요 메소드


## toString() 메소드, 객체를 문자열로 변환
각 클래스는 toString()을 오버라이디앟여 자신만의 문자열 리턴 가능
    객체를 문자열로 반환
    원형
컴파일러에 의한 toString() 자동 변환
    '객체 + 문자열' -> '객체.toString() + 문자열'로 자동 변환
    객체를 단독으로 사용하는 경우 -. 객체.toString()으로 자동변환


## 객체 비교(==)와 equals() 메소드
== 연산자
    객체 레퍼런스 비교

boolean equals(Object obj)
    두 객체의 내용물 비교
    객체의 내용물을 비교하기 위해 클래스의 멤버로 작성

## Wrapper 클래스
Wrapper 클래스
    자바의 기본 타입을 클래스화한 8개 클래스를 통칭
용도
    객체만 사용할 수 있는 컬레셕 등에 기본 타입의 값을 사용하기 위해 -> Wrapper 객체로 만들어 사용


## Wrapper 객체 생성
기본 타입의 값으로 Wrapper 객체 생성

문자열로 Wrapper 객체 생성

Float 객체는 double 타입의 값으로 생성 가능


## 박싱과 언박싱
박싱
    기본 타입의 값을 Wrapper 객체로 변환하는 것
언박싱
    Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것
    박싱의 반대
자동 박싱과 자동 언박싱
    JDK 1.5부터 박싱과 언박싱은 자동으로 이루어지도록 컴파일됨


## String의 생성과 특징
String
    String 클래스는 문자열을 나타냄
    스트링 리터럴(문자열 리터럴)은 String 객체로 처리됨
    스트링 객체의 생성 사례


## math 클래스
기본 산술 연산 메소드를 제공하는 클래스
모든 메소드는 static으로 선언

abs
sqrt
exp0
round


## 4얼 12일 강의

## static 맴버의 생성
static 맴버는 클래스당 하나만 생성
객체들의 의해 공유 됨

## static 맴버 사용
클래스 이름으로 접근 가능

객체의 맴버로 접근 가능

non-static 맴버는 클래스 이름으로 접근 안 됨

```java
class Calc {
    int foo;
    static int bar;

    public static int abs(int a) {return a>0?a:-a;}
    public static int max{int a, int b} { return (a>b)?a:b;}
    public static int min{int a, int b} { return (a>b)?b:a;}
}

public class ex4_11 {

    public static void main(String[] args) {
        System.out.println(Calc.abs(-5));
        System.out.println(Calc.max(10, 8));
        System.out.println(Calc.min(-3, -8));
        Calc a = new Calc();
        a.foo = 100;
        Calc.bar =50;
        System.out.println(a.foo);
        System.out.println(Calc.bar);
    }
}
```

## static 메소드의 제약 조건(1,2)
static 메소드는 오직 static 맴버만 접근 가능
    객체가 생성되지 않은 상황에서도 static 메소드는 실해될 수 있기 때문에, non-static 맴버 활용 불가

non-static 메소드는 static 맴버 사용 가능

static 메소드는 this 사용불가
    static 메소드는 객체 없이도 사용 가능하므로, this 레퍼런스 사용할 수 없음


## final 클래스
final 클래스 - 더 이상 클래스 상속 불가능
final 메소드 - 더 이상 오버라이딩 불가능

## final 필드
final 필드, 상수 선언
    상수를 선언할 때 사용
    상수 필드는 선언 시에 초기 값을 지정하여야 한다
    상수 필드는 실행 중에 값을 변경할 수 없다

## 클래스 상속과 객체
상속 선언
    extends 키워드로 선언
        부모 클래스를 물려받아 확장한다는 의미
    부모 클래스 -> 슈퍼 클래스(super class)
    자식 클래스 -> 서브 클래스(sub class)

```java
public class ex5_01 {
    public static void main(String[] args) {
        Point p = new Point();
        p.set(1 , 2);
        p.showPoint();

        ColorPoint cp = new ColorPoint();
        cp.set(3, 4);
        cp.setColor("red");
        cp.showColorPoint();
    }
}

class Point {
    private int x,y;
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}
```

## 서브 클래스 객체의 모양
슈퍼 클래스 객체와 서브 클래스의 객체는 별개
서브 클래스 객체는 슈퍼 클래스 맴버 포함

## 자바 상소긔 특징
클래스 다중 삭송 불허
    C++는 다중 상속 가능
        C++는 다중 상속으로 맴버가 중복 생성되는 문제 있음
    자바는 인터페이스의 다중 상속 허용

모든 자바 클래스는 묵시적으로  Object클래스 상속받음
    java.lang.Objeect는 클래스는 모든 클래스의 슈퍼 클래스

## 슈퍼 크랠스의 멤버에 대한 서브 클래스의 접근
슈퍼 클래스의 private 멤버
    서브 클래스에서 접근할 수 없음

슈퍼 클래스의 디폴트 멤버
    서브 클래스가 동일한 패키ㅈ에 있을 때, 접근 가능

슈퍼 클래스의 public 멤버
    서브 클래스는 항상 접근 가능

슈퍼 클래스의 portected 멤버
    같은 패키지 내의 모든 클래스 접근 허용
    패키지 여부와 상관없이 서브 클래스는 접근 가능

## protected 멤버
protected 멤버에 대한 접근
    같은 패키지의 모든 클래스에게 허용
    상속되는 서브 클래스(같은 패키지든 다른 패키지든 상관 없음)에게 허용

## 서브 클래스/슈퍼 클래스의 생성자 호출과 실행
서브 클래스의 객체가 생성될 때
슈퍼클래스 생성자와 서브 클래스 생성자 모두 실행
    서브 클래스의 생성자 먼저 호출
    서브 클래스의 생성자는 실행 전 슈퍼 클래스 생성자 호출
실행 순서
    슈퍼 클래스의 생성자가 먼저 실행된 후 서브 클래스의 생성자 실행

생성자 - 객체를 초기화 하는 담당


## 서브 클래승와 슈퍼 클래스의 생성자 선택
슈퍼 클래스와 서브 클래스
    각각 여러 개의 생성자 작성 가능

슈퍼 크랠스의 객체가 생성 될 때
    슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행

서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식
1.개발자의 명시적 선택
    서브 클래스 개발자가 슈퍼 크랠스의 생성자 명시적 서낵
    super() 키워드를 이요하여 선택
2.컴파일러가 시본생성자 선택
    서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
    컴파일러가 자동으로 슈퍼 클래스의 시본 생성자 선택

## super()로 슈퍼 클래스의 생성자 명시적 선택
super()
    서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 선택 호출
    사용 방식
        super(parameter);
        인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출
        반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함

## 업캐스팅
업캐스팅
    서브 클래스의 래퍼런스를 슈퍼 클래스 레퍼런스에 대입
    슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상
        슈퍼클래스 레퍼런스로 객체 내의 슈퍼 클래스의 맴버만 접근 가능

## 다운캐스팅
다운캐스팅
    슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 대입
    업캐스팅된 것을 다시 원래대로 되돌리는 것
    반드시 명시적 타입 변환 지정

## 업캐스팅 레퍼런스로 객체 구별?
어배스팅 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
    슈퍼 클래스는 여러 서브 클래스에 상속되기 때문

## instanceof 연산자 사용
instanceof 연산자
    instanceof 연산자
        레퍼런스가 가리키는 객체의 타입 식별

## 메소드 오버라이딩의 개념
메소드 오버라이딩
    서브 클래스에서 슈퍼 크랠스의 메소드 중복 작성
    슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨
    "메소드 무시하기"로 번역되기도 함

오버라이딩 조건
    슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 개수, 리턴 타입) 동일하게 작성

## 오버라이딩의 목적, 다형성 실현
오버라이딩으로 다형성 실현
    하나의 인터페이스(같은 이름)에 서로 다른 구현
    슈퍼 클래스의 메소드를 서브 클래스에서 각각 목적에 맞게 다르게 구현

## 추상 클래스
추상 메소드
    abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언

추상 클래스
    추상 메소드를 가지며, abstract로 선언된 클래스
    추상 메소드 없이, abstract로 선언한 클래스


## 4월 5일 강의
## 2차원 배열

    intArray[]
```java
ex 3-10
```
## 배열 리턴

    배열의 레퍼런스만 리턴(배열 전체가 리턴되는 것이 아님)

## 메소드의 리턴 타입

    리턴하는 배열 타이과 리턴 받는 배열 타입 일치
    리턴 타입에 배열의 크기를 지정하지 않음

## 자바의 예외 처리

## 예외

    실행 중 오동작이나 결과에 악영향을 미치는 예상치 못한 상황
    자바에서는 실행 중 발생하는 에러를 예외로 처리

## 실행 중 예외가 발생하면

    자바 플래폿은 응용프로그램이 예외를 처리하도록 호출
    응용프로그램이 예외를 처리하지 않으면 프로그램 강제 종료 시킴

## 예외 발생 경우

    정수를 0으로 나누는 경우
    배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우
    정수를 읽는 코드가 실행되고 있ㅇ르 때 사용자가 문자를 입력한 경우

## 자바의 예외처리

    try-catch-finally문

## 예외 처리
    
    발생한 예외에 대해 개발자가 작성한 프로그램 코드에서 대응하는 것

try-catch-finally문 사용
    finally블록은 생략 가능
    
    try{
        예외가 발생할 가능성이 있는 실행문(try 블록)
    }
    catch (처리할 예외 타입 선언) {
        예외 처리문(catch 블록)
    }
    finally {
        예외 발생 여부와 상관 없이 무조건 실행되는 문장(finally 블록) //생략가능
    }

```java
import java.util.Scanner;

public class ex3_13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print("나뉨수를 입력하시오:");
        dividend = scanner.nextInt();
        System.out.print("나눗수를 입려하시오");
        divisor = scanner.nextInt();
        try {
            System.out.println(dividend+"를 "+ divisor+"로 나누면 몫은 " + dividend/divisor + "입니다. ");
        }
        catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다!");
        }
        finally{
            scanner.close();
        }
    }
}
```
## 세상 모든 것이 객체다

## 실세계 객체의 특징
 
    객체마다 고유한 특성와 행동을 가짐
    다른 객체들과 정보를 주고 받는 등, 상호작용하면서 살아감

## 컴퓨터 프로그램에서 객체 사례

    테트리스 게임의 각 블록들
    한글 프로그램의 메뉴나 버튼들

## 갭슐화 

    객체를 캡슐로 싸서 내부로 볼 수 없게 하는 것
        객체의 가장 본질적인 특징(외부의 접근으로 부터 보호)

## 자바의 캡슐화

    클래스 : 객체 모양을 선언한 틀(캡슐화하는 틀)
    객체 : 생성된 실체 (클래스 내에 메소드와 필드 구현)

## 상속

    상위 개체의 속성이 하위 개체에 물려짐
    하위 개체가 상위 개체의 속성을 모두 가지는 관계

## 자바 상속

    상위 클래스의 맴버를 하위 클래스가 물려받음
    상위 클래스 : 수퍼 클래스
    하위 클래스 : 서브 클래스, 수퍼 클래스 코드의 재사용, 새로운 특성 추가 가능

## 다형성

    같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현되는 것
    다형성 사례
    메소드 오버로딩 : 한 클래스 내에서 같으 ㄴ이름이지만 드르게 작동하느 ㄴ여러 메소드
    메소드 오버라이딩 : 슈퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

## 객체 지향 언어의 목적

    1.소프트웨어의 생산성 향상
        컴퓨터 산업 발전에 따라 소프트웨어의 생명 주기 단축
            소프트웨어를 빠른 속도로 생산할 필요성 증대
        객체 지향 언어
            상속, 다향성, 객체, 캡슐화 등 소프트웨어 재사용을 위한 여러 장치 내장
            소프트웨어 재사용과 부분 수정 빠름
            소프트웨어를 다시 만드는 부담 대폭 줄임
            소프트웨어 생산성 향상
    2.실세계에 대한 쉬운 모델링
        초기 프로그래밍
            수학 계산/통계 처리를 하는 등 러치 과정, 계산 절차 중요
        현대 프로그래밍
            컴퓨터가 산업 전반에 활용
            실세계에서 발생하는 일을 프로그래밍
            실세계에서는 절차나 과정보다 물체(객체)들의 상호 작용으로만듬
        객체 지향 언어
            실세계의 일을 보다 쉽게 프로그래밍하기 위한 객체 중심

## 절차 지향 프로그래밍과 객체 지향 프로그래밍

    절차 지향 프로그래밍
        작업 순서를 표현하는 컴퓨터 명령 집함
        함수들의 집합으로 프로그램 작성
    객체 지향 프로그래밍
        컴퓨터가 수행하는 작업을 객체들간의 상호 작용으로 표현
        클래스 혹은 객체들의 집합으로 프로그램 작성

##  클래스와 객체

    클래스
        객체의 속성과 행위 선언
        객체의 설계도 혹은 틀
    
    객체
        클래스의 틀로 찍어낸 실체
            프로그램 실행 중에 생성되는 실체
            메모리 공간을 갖는 구체적인 실체
            인스턴스라고도 부름
    사례
        클래스:벽시계  객체:집 벽에 걸린 벽시계들
        클래스:책상    객체:우리가 사용중인 책상들

##  클래스

    class 키워드로 선언
    맴버 : 클래스 구성 요소
    클래스에 대한 public 접근 지정 : 다른 모든 클래스에서 클래스 사용 허락
    맴버에 대한 public 접근 지정 : 다른 모든 클래스에게 맴버 접근 허용

## 클래스 만들기 연습
```java
import java.util.Scanner;

public class RectApp {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();   // 객체 생성
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        rect.width = scanner.nextInt();
        rect.height = scanner.nextInt();
        System.out.println("사각형의 면적은 " + rect.getArea());
        scanner.close();
    }
    
}


class Rectangle {
    int width;
    int height;
    public int getArea() {
        return width*height;
    }
}
```

## 생성자
    객체가 생성할 때 초기화 목적으로 실행되는 메소드
    객체가 생성되는 순간에 자동 호출

## 생성자의 특징

    생성자 이름은 클래스 이름과 동일
    생성자는 여러 개 작성 가능(생성자 중복)
    생성자는 객체 생성시 한 번만 호출
    생성자의 목적은 개게 생성 시 초기화
    생성자는 리턴 타입을 지정할 수 없음

##  생성자 호출 및 선언 연습
```java
public class ex4_04 {
    String title;
    String author;

    public ex4_04(String t) {
        title = t; author = "작자마상";
    }

    public ex4_04(String t, String a) {
        title = t; author = a;
    }

    public static void main(String[] args) {
        ex4_04 littlePrince = new ex4_04("어린왕자", "생텍쥐페리");
        ex4_04 loveStory = new ex4_04("춘향전");
        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
}
```

## 기본 생성자

    매개 변수 없고, 아무 적업 없이 단순 리턴하는 생성자

## this 레퍼런스

    개체 자시에 대한 레퍼런스
    컴파일러에 의해 자동 관리, 개발자는 사용하기만 하면 됨
    this.맴버 형태로 맴버를 접근할 때 사용

## this()로 다른 생성자 호출

    같은 클래스의 다른 생성자 호출
    생성자 내에서만 사용 가능
    생성자 코드의 제일 처음에 있어야함

## 객체 배열

    자바의 객체 배열
        객체에 대한 레퍼런스 배열임
    자바의 객체 배열 만들기 3단계
        배열 레퍼런스 변수 선언
        레퍼런스 배열 생성
        배열의 각 원소 객체 생성

## 메소드

    메소드는 C/C++의 함수와 동일
    자바의 모든 메소드는 반드시 클래스 안에 있어야 함(캡슐화 원칙)

    메소드 형식
        접근 지정자, 리턴 타입, 메소드 이름, 메소드 인자들, 메소드 코드

    접근 지정자
        다른 클래스에서 메소드를 접근할 수 있는지 여부 선언
    리턴 타입
        메소드가 리턴하는 값의 데이터 타입
    
## 메소드 오버로딩

    오버로딩
    한 클래스 냉에서 두 개 이상의 이름이 가은 메소드 작성
        메소드 이름이 동일하여야 함
        매개 변수의 개수가 서로 다르거나, 타입이 서로 달라야함
        리턴 타입은 오버로딩과 관련 없음

## 객체 소멸

    객체 소멸
        new에 의해 할당 받은 객체와 배열 메모리를 자바 가상 기계로 되돌려 주는 행위
        소멸된 객체 공간은 가용 메모리에 포함

    자바에서 사용자 임의로 객체 소멸안됨
        자바에서 객체 소멸 여산자 없음
        객체 소멸은 자바 가상 기계의 고유한 역할
        자바 개발자에게는 매우 다행스러운 기능

## 가비지
    
    가비지
        가리키는 레퍼런스가 하나도 없는 객체
    가비지 컬렉션
        자바 가상 기계의 가비지 컬렉터가 자동으로 가비지 수집, 반환

## 가비지 컬렉션

    가비지 컬렉션
        자바 가상 기게가 가비지 자동 회수
            가용 메모리 공간이 일정 이하로 부족해질 때
            가비지를 수거하여 가용 메모리 공간으로 확보
        가비지 컬렉터에 의해 자동 수행
    
    강제 가비지 컬렉션 강제 수행
        System(); //가ㅣ지 컬렉션 작동 요청
    
## 가바의 패키지 개념
    
    패키지
        상호 관련 있는 클래스 파일을 저장하여 관리하는 디렉터리
        자바 응용프로그램은 하나 이상의 패키지로 구성

## 접근 지정자

    자바의 접근 지정자
        4가지
            private, protected, public, 디폴트(접근지정자 생략)
        접근 지정자의 목정
            클래스나 일부 맴버를 공개하여 다른 클래스에서 접근하도록 허용
            객체 지향 언어의 캡슐화 정책은 맴버를 보호하는 것

## 클래스 접근 지정
    
    클래스 접근지정
        다른 클래스에서 사용하도록 허용할 지 지정
        public 클래스
            다른 모든 클래스에게 접근 허용
        디폴트 클래스(접근지정자 생략)
            package-pravite라고도 함
            같은 패키지의 클래스에만 접근 허용


## 3월 29일 강의
## 타입 변환

    한 타입의 값을 다른 타입의 값으로 변환

## 자동 타입 변환

    컴파일러에 의해 원래의 타입보다 큰 타입으로 자동 변환
    치한문(=)이나 

## 강제 타입 변환

    개발자의 의도적 타입변환
    ()안에 개발자가 일시적으로 타입 변환 지정

```java
import java.util.Scanner;

public class ex2_5 {
    public static void main(String[] args) {
        System.out.println("이름, 도시, 나이, 체중, 독신 여부를 빈칸으로 분리하여 입력하세요");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("당신의 이름은 " + name + "입니다.");
        String city = scanner.next();
        System.out.println("당신이 사는 도시는 " + city + "입니다.");
        String age = scanner.next();
        System.out.println("당신의 나이는 " + age + "입니다.");
        String weight = scanner.next();
        System.out.println("당신의 체중은 " + weight + "입니다.");
        String single = scanner.next();
        System.out.println("당신의 독신 여부는 " + single + "입니다.");
    }
}
```
## 연산

    주어진 시을 계산하여 결과를 얻어내는 과정

연산의 종류             연산자
증강                ++ --
산술                + - * / %
시프트              >> << >>>
비교                > < >= <= == !=
비트                & | ^ ~
논리                && || ! ^
조건                ? :
대입                = *= /= -= &= ^= |= <<= >>= >>>=


## 증감 연산      연산자
a++               a를 1 증가하고 증가 전의 값 반환
a--               a를 1 감소하고 감소 전의 값 반환
++a               a를 1 증가하고 증가된 값 반환
--a               a를 1 감소하고 감소된 값 반환


## 대입 연산               내용
a = b               b의 값을 a에 대입
a += b              a = a + b
a -= b              a = a - b
a *= b              a = a * b
a /= b              a = a / b
a %= b              a = a % b
a &= b              a = a & b
a ^= b              a = a ^ b
a |= b              a = a | b
a <<= b             a = a << b
a >>= b             a = a >> b
a >>>= b            a = a >>> b


## 비트 논리 연산

    피 연산자의 각 비트들을 대상으로 하는 연산

## 연산자          별칭            내용
a & b         AND 연산         두 비트 모두 1이면 1, 그렇지 않으면 0
a | b         OR 연산          두 비트 모두 0이면 0, 그렇지 않으면 1
a ^ b         XOR 연산         두 비트가 다르면 1, 같으면 0
 ~ a          NOT 연산         을 0으로, 0을 1로 변환

```java
import java.util.Scanner;

public class ex2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 입력하세요 : ");
        int time = scanner.nextInt(); // 정수 입력
        int second = time % 60; // 60으로 나눈 나머지는 초
        int minute = (time / 60) % 60; // 60으로 나눈 몫을 다시 60으로 나눈 나머지는 분
        int hour = (time / 60) / 60; // 60으로 나눈 몫을 다시 60으로 나눈 몫은 시간

        System.out.print(time + "초는 ");
        System.out.print(hour + "시간, ");
        System.out.print(minute + "분, ");
        System.out.print(second + "초입니다. ");
        scanner.close();
    }
}
```
## 조건문 - 단순 if 문, if-else 문

## 단순 if 문

    if의 괄호 안에 조건식(논리형 변수나 논리 연산)
## if-else 문

    조건식이 true면 실행문장1, false이면 실행문장2 실행


## swith문

## swich문은 식과 case 문의 값과 비교

    case의 비교 값과 일치하면 해당 case의 실행문장 수행
        break를 만나면 swich문을 벗어남

    case의 비교 값과 일치하는 값이 없으면 delfault 문 실행
        default문은 생략 가능


## case 문의 값

    문자, 정수, 문자열 리터럴(JDK 1.7부터)만 허용
    실수 리터럴은 허용되지 않음


## 반복문

## 자바 반복문 -for 문, do while 문

    for 문 - 가장 많이 쓰는 반복문


## while문
```java
import java.util.Scanner;

public class ex3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count=0, n=0;
        double sum=0;

        System.out.println("정수를 입력하고 마지막에 0을 입력하세요.");
        while((n = scanner.nextInt()) !=0)
            sum = sum + n;
            count++;
    }
    System.out.print("수의 개수는 " + count + "개이며 ");
    System.out.println("평균은 " + su/count + "입니다.");

    scanner.close();
}
```


## 중첩문(ex:구구단 만들기)
```java
public class ex3_4 {
    public static void main(String[] args)  {
        for(int i=1; i<10; i++) { 
             for(int j=1; j<10; j++) { 
                 System.out.print(i + "x" + j + "=" + i*j); 
                 System.out.print('\t'); 
             }
             System.out.println(); 
        }
 }
}
```

## 자바 배열

## 배열 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조

    배열을 이용하면 한 번에 많은 메모리 곤간 선언 가능

## 배열은 같은 타입의 데이터들이 순차적으로 저장되는 공간

    원소 데이터들이 순차적으로 저장됨
    인덱스를 이용하여 원소 데이터 접근
    반복문을 이용하여 처리하기에 적합한 자료 구조

## 배열 인덱스

    0부터 시작
    인덱스는 배열의 시작 위치에서부터 데이터가 있는 상대 위치


for-each문
```java
ex3-9
```


## 3월 22일 강의

1. ctrl + shipt + p
2. >create java project
3. 폴더선택
4. 프로젝트 이름 입력
5. java2-1 폴더 안에 있는 폴더 4개만 복사
    VScade
    bim
    lib
    src 4개를 복사해서 지난번에 만든 java2-1 폴더에 README.md 아래에 복사

프로그래밍 언어에는 저급 언어와 고급언어가 있음

저급 언어는 컴퓨터가 알아듣는 언어 (기계어 , 어셈블리어)  

고급언어는 간단하게 사람이 이해하기 쉬운 언어 (C/C++, Java)  

소스:프로그래밍 언어로 작성된 텍스트 파일  
컴파일:소스 파일을 컴퓨터가 이해할 수 있는 기계어로 만드는 과정

WORA : 한번 작성된 코드는 모든 플랫폼에서 바로 실행되는 자바의 특징

WORA를 가능하게 만드는 자바의 특징

1. 바이트 코드(byte code)
    1-1 자바 소스를 컴파일한 목적코드
    1-2 CPU에 종속적이지 않은 중립적인 코드
2. JVM(Java Virtual Machine)

JDK(java Development Kit)
JRE(Java Runtime Environment)

IDE(integrated development environment) 란? 

    통합 개발 환경이다
    편집, 컴파일, 디버깅을 한번에 할수있는 통합된 개발 환경

안드로이드 : 구글의 주도로 여러 모바일 회사가 모여 구성한
OHA (Open Handset Alliance)에서 만든 무료 모바일 플랫폼

``` java
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

실행 코드 배포

## 구성

    한 개의 또는 다수의 class 파일로 구성
    여러 폴더에 걸쳐 다수 클래스 파일로 구성 된 경우 : jar 압축 파일로 배포

## 자바 응용프로그램의 실행은 main() 메소드에서 시작

    하나의 클래스 파이에 두 개 이상의 main() 메소드가 있을 수 없음

## 패키지

    서로 관련 있는 여러 클래스를 패키지로 묶어 관리
    패키지는 폴더 개념

## 멀티스레드

    여러 스레드의 동시 수행 환경 지원
    자바는 운영체제의 도움 없이 자체적으로 멀티스레드 지원
    C/C++ 프로그램은 멀티스레드를 위해 운영체제 API를 호출

## 가비지 컬렉션

    자바 언어는 메모리 할당 기능은 있어도 메모리 반환 기능 없음
    사용하지 않는 메모리는 가바 가상 기계에 의해 자동 반환 가비지 컬렉션

## 실시간 응요프로그램에 부적합

    실행 도중 예측할 수 없는 시점에 가비지 컬렉션 실행 때문
    응용프로그램의 일시적 중단 발생

## 자바 프로그램은 안전

    타임 체크 엄격
    물리적 주소를 사용하는 포인터 개념 없음

## 프로그램 작성 쉬움

    포인터 개념이 없음
    동적 메모리 반환 하지 않음
    여러 라이브러리 지원

## 실행 속도 개선을 위한 JIT 커파일러 사용

    자바는 바이트 코드를인터프로리터 방식으로 실행
    기계어가 실행되는 것보다 느림
    JIT 컴파일 기법으로 실행 속도 개선
    JIT컴파일 - 실행 중에 바이트 코드를 기계어 코드로 컴파일 하여 기계어를 실행하는 기법

예제 2-1 (교제)
```java
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("println1");
        System.out.println("println2");
        System.out.print("print1");
        System.out.print("print2");
    }
}
```
## 식별자
    클래스, 변수, 상수, 메소드 등에 붙이는 이름
## 식별자의 원칙
    @ , # , ! 와 같은 특수 문자, 공백 또는 탭은 식별자로 사용할 수 없으나 _ , & 는 사용 가능
    유니코드 문자, 한글 사용 가능
    자바 언어의 키워드는 식별자로 사용불가
    식별자의 첫 번째 문자로 숫자는 사용불가
    _ 또는 $를 실벽자 첫 번째 분자로 사용할 수 있으나 일반적으론 잘 사용하지 않음
    길이 제한이 없음

대소문자 구별
int barChart; 와 int barchart;는 서로 다른 식별자 선언

자바의 데이터 타입
기본 타입 : 8개
boolean
char
byte
short
int
long
float
double

레퍼런스 타입 : 1개이며 용도는 클래스, 인터페이스, 배열에 대한 3가지가 있다

변수 : 프로그램 실행 중에 값을 임시 저장하기 위한 공간
    변수 값은 프로그램 수행 중 변경될 수 있음



예제 2-2 (var 키워드)
```java
public class App {
    public static void main(String[] args) throws Exception {
        var foo = 200;
        var name = " woogie";
        
        System.out.println(foo + name);
    }
}
```


## 3월 15일 강의

이클립스 보다는 Visual Studio Code가  
자동완성 기능이 있어서 편리하다  
이클립스도 자동완성이 있긴 하지만 훨씬 더 편리하다  

실행 버튼은 public class 밑에있는  
Run을 누르거나 오른쪽 상단에 있는 버튼을 누르면 실행된다  
또는 F5로도 실행을 시킬 수 있다.  

``` java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello!!! VScode가 좋아요");
    }
}
```