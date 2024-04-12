## 202330109 김태경

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