package ch03_class.basic.ch06.sec00.intro.constructor;
import java.util.Date;

public class User {

    String id;
    String pwd;
    String name;
    Date enrollDate; //생성일시

    /*
     * 생성자의 작성 위치
     *
     * 문법상으로 클래스 내부에 작성하면 되지만,
     * 통상적으로 필드 선언부와 메소드 선언부 사이에 적는 것이 관례
     * */

    /*
     * 생성자의 사용목적
     *
     * 1. 인스턴스 생성 시점에 수행할 명령이 있는 경우 사용한다.
     * 2. 매개변수 있는 생성자의 경우 매개변수로 전달받은 값으로 필드를 초기화하며,
     *    인스턴스를 생성할 목적으로 주로 사용된다.
     * 3. 작성한 생성자 외에는 인스턴스를 생성하는 방법을 제공하지 않겠다는 의미
     *    -> 인스턴스를 생성하는 방법을 제한하기 위한 용도로 사용 (초기값 전달 강제)
     * */

    /*
     * 생성자 작성 시 주의할 점
     * 1. 생성자 메소드는 반드시 클래스의 이름과 동일해야 한다.(대/소문자까지)
     * 2. 생성자 메소드는 반환형을 작성하지 않는다. (작성하는 경우에 생성자가 아닌 일반 메소드로 인식)
     * */

    /*
     * 생성자의 종류
     * 1. 기본 생성자 (매개변수가 없는 생성자)
     *
     * 2. 매개변수 있는 생성자
     *
     * 매개변수가 있는 생성자가 한개라도 존재하면 기본생성자를 자바 Compiler가 자동으로 추가하지 않는다.
     * 기본 생성자가 필요한 경우에는 반드시 명시적으로 작성을 해야한다.
     * */

    // 기본생성자
    public User() {

        System.out.println("User 클래스의 기본 생성자 호출함...");
    }

    public String getInfo() {
        return "User [id=" + this.id + ", pwd=" + this.pwd + ", " +
                "name=" + this.name + ", enrollDate=" + this.enrollDate + "]";
    }


    // 매개변수 있는 생성자 (id, pwd, name의 초기화를 담당)
    //
    // 오버로딩  <-------> 오버라이딩은 완전다른것
    // 같은 이름의 메소드나 생성자를
    // 매개변수의 개수나 타입을 다르게 하여 여러개 선언하는 것
    public User(String id, String pwd, String name) {
        // 매개변수 있는 생성자의 주목적 -> 인스턴스 생성 시점에 필드를 원하는 값으로 초기화하기 위함
        this.id = id;
        this.pwd = pwd;
        this.name = name;

        System.out.println("User 클래스의 id, pwd, name을 초기화 하는 생성자 호출함...");
    }


    // 모든 필드를 초기화 하는 생성자 (id, pwd, name, enrollDate)
    public User(String id, String pwd, String name, Date enrollDate) {

//        this.id = id;
//        this.pwd = pwd;
//        this.name = name;
//        this.enrollDate = enrollDate;

        /*
         * this() 사용하기
         * this() 는 동일 클래스 내에 작성한 다른 생성자 메소드를 호출하는 구문이다.
         * 괄호 안에 매개변수의 타입, 갯수, 순서에 맞는 생성자를 호출하고 복귀한다.(메소드 동일)
         * this() 는 가장 첫 줄에 선언해야 하며, 그렇지 않은 경우 Compile Error가 발생한다.
         * */

        this(id, pwd, name); // 미리 작성한 3개의 필드를 초기화하는 생성자로 매개변수로 받은 값을 전달.

        this.enrollDate = enrollDate;

        System.out.println("User 클래스의 모든 필드를 초기화 하는 생성자 호출함...");
    }

    /*
     * 복사 생성자
     *
     * -> 같은내용의 인스턴스를 만들때 사용
     * 동일한 값을 가지지만 새롭게 할당되는 인스턴스이기때문에 서로다른 주소값을 가지게 된다.
     * => 깊은복사
     * */
    public User(User otherUser) {
        this.id = otherUser.id;
        this.pwd = otherUser.pwd;
        this.name = otherUser.name;
        this.enrollDate = otherUser.enrollDate;

        System.out.println("User 클래스의 복사생성자 호출함...");
        System.out.println("this의 hashCode : " + this.hashCode());
        System.out.println("otherUser의 hashCode : " + otherUser.hashCode());
    }



}
