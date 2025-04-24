package ch07_exception_handling.basic.ch11.sec03.sec04;

public class TryWithResourceExample {

    public static void main(String[] args) {
        // 일반 try-catch 블록 사용 예
        try {
            MyResource res = new MyResource("A");
            String data = res.read1();
            int value = Integer.parseInt(data);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        try {
            MyResource res = new MyResource("A");
            String data = res.read2();
            int value = Integer.parseInt(data);
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        // try-with-resources 블록 사용 예
//        try (
//                MyResource res1 = new MyResource("A");
//                MyResource res2 = new MyResource("B")
//        ) {
//            String data1 = res1.read1();
//            String data2 = res2.read1();
//            System.out.println(data1);
//            System.out.println(data2);
//        } catch (Exception e) {
//            System.out.println("예외 처리: " + e.getMessage());
//        }
    }
}
