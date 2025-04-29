package ch09.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 중첩 인터페이스와 익명 내부 클래스를 보여주는 간단한 예제
 * 
 * 이 예제는 다음 개념들을 보여줍니다:
 * 1. 중첩 인터페이스 (Nested Interface) - MessageHandler
 * 2. 익명 내부 클래스 (Anonymous Inner Class) - ActionListener와 MessageHandler 구현체
 */
public class ButtonAdapterExample extends JFrame {

  /**
   * 중첩 인터페이스 (Nested Interface) 예제
   * 
   * 특징:
   * 1. 클래스 내부에 선언된 인터페이스
   * 2. public으로 선언되면 외부에서도 접근 가능 (SimpleNestedExample.MessageHandler 형태로)
   * 3. 주로 특정 클래스와 강하게 연관된 기능을 정의할 때 사용
   * 4. 논리적 그룹화와 캡슐화에 도움이 됨 
   */
  public interface MessageHandler {
    // 메시지를 처리하는 단순한 메소드
    void printMessage(String message);
  }

  // UI 컴포넌트 선언
  private JTextField messageField;
  private JButton sendButton;

  public ButtonAdapterExample() {
    // 기본 JFrame 설정
    setTitle("중첩 인터페이스 예제");
    setSize(400, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout()); // 
    setLocationRelativeTo(null); // 중앙 배치

    // UI 컴포넌트 초기화
    messageField = new JTextField(20);
    sendButton = new JButton("메시지 출력");
    
    // 컴포넌트 추가
    add(new JLabel("메시지: "));
    add(messageField);
    add(sendButton);

    /**
     * 익명 내부 클래스 (Anonymous Inner Class)로 MessageHandler 구현
     * 
     * 특징:
     * 1. 이름이 없는 클래스로, 선언과 동시에 인스턴스 생성
     * 2. 단 하나의 객체만 생성할 수 있음
     * 3. 주로 인터페이스나 추상 클래스를 구현/상속하여 일회성으로 사용할 때 유용
     */
    
    /* 하나의 내부 인터페이스를 두가지 방식으로 구현*/
    final MessageHandler messageHandlerA = new MessageHandler() {
      @Override
      public void printMessage(String message) {
        // 간단하게 콘솔에 메시지 출력
        System.out.println("[메시지] " + message);
      }
    };

    final MessageHandler messageHandlerB = new MessageHandler() {
      @Override
      public void printMessage(String message) {
        // 현재 시간 + message 출력
        String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

        System.out.printf("[%s] %s\n", formattedDateTime, message);
      }
    };




    /**
     * 익명 내부 클래스로 ActionListener 구현
     * 
     * 이벤트 리스너 구현에 익명 내부 클래스가 매우 자주 사용됨
     */
    sendButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String message = messageField.getText();
        if (!message.isEmpty()) {
          // 메시지 핸들러를 통해 메시지 출력
          messageHandlerA.printMessage(message);
          messageHandlerB.printMessage(message);

          // 입력 필드 초기화
          messageField.setText("");
          
          // 메시지 전송 확인
          // ButtonAdapterExample.this == 외부 인스턴스
          JOptionPane.showMessageDialog(ButtonAdapterExample.this,
                  "메시지가 콘솔에 출력되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
          // SimpleNestedExample.this는 외부 클래스의 인스턴스를 참조
          // 익명 클래스에서 외부 클래스의 멤버에 접근할 때 필요함
          JOptionPane.showMessageDialog(ButtonAdapterExample.this,
                  "전송할 메시지를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }


}