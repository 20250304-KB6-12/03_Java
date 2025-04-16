package ch01_variable_tpye_operator.basic.ch01.verify;

public class VariableInitializationExample {
    public static void main(String[] args) {
        // value 변수를 초기화 하지 않고 사용하기 때문에 컴파일 에러발생
//        int value;
        int value = 10 ;

        int result = value + 10;
        System.out.println(result);
    }
}