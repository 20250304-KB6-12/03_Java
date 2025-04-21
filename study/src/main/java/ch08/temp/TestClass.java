package ch08.temp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestClass {
  public static void main(String[] args) {

    // 인터페이스 이용 시 유지보수성 향상 - 객체 교환
    // ArrayList : 검색 속도 빠름, 중간에 데이터 추가/수정/제거 느림
    // LinkedList : 검색 속도 느림, 중간에 데이터 추가/수정/제거 빠름
//    List<String> list = new ArrayList<String>();
    List<String> list = new LinkedList<String>();

    // 1. 인터페이스를 상속 받은 객체들은
    // 같은 이름의 메서드를 지니고 있다(오버라이딩 강제화)

    // 2. 인터페이스 타입 변수 = new 상속 받은 자식 클래스();
    //   -> 다형성 (업캐스팅)
    //   + 동적 바인딩 :
    //      실제 참조 중인 객체(ArrayList 또는 LinkedList)의 add() 와 연결

    // 3. 인터페이스 제공 메서드를 호출
    //  (모든 자식 클래스는 인터페이스에서 제공 받은 메서드를 가지고 있다!)
    //  --> 인터페이스 타입 변수 = new 상속 받은 자식 클래스(); 에서
    //     자식 클래스(A)를 다른 자식 클래스(B)로 변경할 수 있다!!


    list.add("짬뽕");
    list.add("짜장");
    list.add("탕수육");
    list.add(1, "간짜장");
    list.add(0, "크림새우");
    list.add(0, "크림새우");
    list.add(0, "크림새우");
    list.add(0, "크림새우");
    list.add(0, "크림새우");
  }
}
