## 3월 29일 강의
타입 변환
    한 타입의 값을 다른 타입의 값으로 변환

자동 타입 변환
    컴파일러에 의해 원래의 타입보다 큰 타입으로 자동 변환
    치한문(=)이나 

강제 타입 변환
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
연산
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


증감 연산
연산자
a++               a를 1 증가하고 증가 전의 값 반환
a--               a를 1 감소하고 감소 전의 값 반환
++a               a를 1 증가하고 증가된 값 반환
--a               a를 1 감소하고 감소된 값 반환


대입 연산               내용
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


비트 논리 연산
    피 연산자의 각 비트들을 대상으로 하는 연산

연산자          별칭            내용
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
조건문 - 단순 if 문, if-else 문
단순 if 문
    if의 괄호 안에 조건식(논리형 변수나 논리 연산)
if-else 문
    조건식이 true면 실행문장1, false이면 실행문장2 실행


swith문
swich문은 식과 case 문의 값과 비교
    case의 비교 값과 일치하면 해당 case의 실행문장 수행
        break를 만나면 swich문을 벗어남
    case의 비교 값과 일치하는 값이 없으면 delfault 문 실행
        default문은 생략 가능


case 문의 값
    문자, 정수, 문자열 리터럴(JDK 1.7부터)만 허용
    실수 리터럴은 허용되지 않음


반복문
자바 반복문 -for 문, do while 문
    for 문 - 가장 많이 쓰는 반복문


while문
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


중첩문(ex:구구단 만들기)
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

자바 배열
배열 인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조
    배열을 이용하면 한 번에 많은 메모리 곤간 선언 가능
배열은 같은 타입의 데이터들이 순차적으로 저장되는 공간
    원소 데이터들이 순차적으로 저장됨
    인덱스를 이용하여 원소 데이터 접근
    반복문을 이용하여 처리하기에 적합한 자료 구조
배열 인덱스
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
구성
    한 개의 또는 다수의 class 파일로 구성
    여러 폴더에 걸쳐 다수 클래스 파일로 구성 된 경우 : jar 압축 파일로 배포
자바 응용프로그램의 실행은 main() 메소드에서 시작
    하나의 클래스 파이에 두 개 이상의 main() 메소드가 있을 수 없음

패키지
    서로 관련 있는 여러 클래스를 패키지로 묶어 관리
    패키지는 폴더 개념

멀티스레드
여러 스레드의 동시 수행 환경 지원
    자바는 운영체제의 도움 없이 자체적으로 멀티스레드 지원
    C/C++ 프로그램은 멀티스레드를 위해 운영체제 API를 호출

가비지 컬렉션
자바 언어는 메모리 할당 기능으 ㄴ있어도 메모리 반환 기능 없음
    사용하지 않는 메모리는 가바 가상 기계에 의해 자동 반환 가비지 컬렉션

실시간 응요프로그램에 부적합
실행 도중 예측할 수 없는 시점에 가비지 컬렉션 실행 때문
    응용프로그램의 일시적 중단 발생

자바 프로그램은 안전
    타임 체크 엄격
    물리적 주소를 사용하는 포인터 개념 없음

프로그램 작성 쉬움
    포인터 개념이 없음
    동적 메모리 반환 하지 않음
    여러 라이브러리 지원

실행 속도 개선을 위한 JIT 커파일러 사용
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
식벼자
클래스, 변수, 상수, 메소드 등에 붙이는 이름
식별자의 원칙
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