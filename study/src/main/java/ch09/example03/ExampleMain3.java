package ch09.example03;

import javax.swing.*;

public class ExampleMain3 {
  public static void main(String[] args) {
    // 또 다른 익명 내부 클래스 예제 - Runnable 인터페이스 구현
    // Swing UI는 이벤트 디스패치 스레드에서 실행해야 함
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        // 애플리케이션 시작
        new ButtonAdapterExample().setVisible(true);
      }
    });

    // Java 8 이상에서는 람다식으로 다음과 같이 간단하게 작성 가능:
    // SwingUtilities.invokeLater(() -> new ButtonAdapterExample().setVisible(true));
  }
}
