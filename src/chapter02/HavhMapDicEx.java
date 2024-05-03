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
