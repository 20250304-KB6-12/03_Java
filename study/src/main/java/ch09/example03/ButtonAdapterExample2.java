package ch09.example03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 중첩 클래스, 중첩 인터페이스와 어댑터 패턴을 보여주는 예제
 * 
 * 이 예제는 다음 개념들을 보여줍니다:
 * 1. 중첩 인터페이스 (Nested Interface) - MessageHandler
 * 2. 정적 중첩 클래스 (Static Nested Class) - LegacyPrinter
 * 3. 지역 내부 클래스 (Local Inner Class) - PrinterAdapter
 * 4. 익명 내부 클래스 (Anonymous Inner Class) - ActionListener 구현체
 * 5. 어댑터 패턴 (Adapter Pattern) - 호환되지 않는 인터페이스를 함께 작동하도록 함
 */
public class ButtonAdapterExample2 extends JFrame {

  /**
   * 중첩 인터페이스 (Nested Interface) 예제
   *
   * 특징:
   * 1. 클래스 내부에 선언된 인터페이스
   * 2. public으로 선언되면 외부에서도 접근 가능 (ButtonAdapterExample.MessageHandler 형태로)
   * 3. 주로 특정 클래스와 강하게 연관된 기능을 정의할 때 사용
   * 4. 논리적 그룹화와 캡슐화에 도움이 됨
   */
  public interface MessageHandler {
    // 메시지를 처리하는 단순한 메소드
    void handleMessage(String message);
  }

  /**
   * 정적 중첩 클래스 (Static Nested Class) 예제
   *
   * 특징:
   * 1. static 키워드가 있는 중첩 클래스
   * 2. 외부 클래스의 인스턴스 없이도 생성 가능 (ButtonAdapterExample.LegacyPrinter 형태로)
   * 3. 외부 클래스의 인스턴스 멤버에 직접 접근 불가 (static이므로)
   * 4. 주로 외부 클래스와 논리적으로 그룹화된 유틸리티 클래스로 활용
   */
  public static class LegacyPrinter {
    // 기존 시스템의 출력 메소드 - 우리가 적응시켜야 할 외부 시스템의 API
    public void printWithPrefix(String prefix, String content) {
      System.out.println("[" + prefix + "] " + content);
    }
  }

  // UI 컴포넌트 선언
  private JButton sendButton;
  private JTextField messageField;
  private JTextArea outputArea;

  // 어댑터 패턴에서 클라이언트가 사용할 타겟 인터페이스 타입 변수
  private MessageHandler messageHandler;

  public ButtonAdapterExample2() {
    // 기본 JFrame 설정
    setTitle("메시지 핸들러 예제");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(10, 10));

    // UI 컴포넌트 초기화
    JPanel inputPanel = new JPanel(new FlowLayout());
    messageField = new JTextField(20);
    sendButton = new JButton("메시지 전송");
    outputArea = new JTextArea(10, 30);
    outputArea.setEditable(false);
    
    // 패널에 컴포넌트 추가
    inputPanel.add(new JLabel("메시지: "));
    inputPanel.add(messageField);
    inputPanel.add(sendButton);
    
    // 메인 창에 패널과 출력 영역 추가
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(outputArea), BorderLayout.CENTER);

    // 기존 프린터 객체 생성 - 이것이 어댑터 패턴에서 적응시켜야 할 객체(Adaptee)입니다
    LegacyPrinter legacyPrinter = new LegacyPrinter();

    /**
     * 지역 내부 클래스 (Local Inner Class) 예제 - 어댑터 패턴 구현
     * 
     * 특징:
     * 1. 메소드 내부에 선언된 클래스
     * 2. 해당 메소드 내에서만 사용 가능 (외부에서 접근 불가)
     * 3. 메소드의 지역 변수와 매개변수에 접근 가능 (final 또는 effectively final이어야 함)
     * 4. 외부 클래스의 모든 멤버(private 포함)에 접근 가능
     * 
     * 어댑터 패턴 구현:
     * - LegacyPrinter(Adaptee)의 인터페이스를 MessageHandler(Target) 인터페이스에 맞게 변환
     * - 클라이언트는 MessageHandler만 알면 되고, LegacyPrinter의 상세 구현은 몰라도 됨
     */
    class PrinterAdapter implements MessageHandler {
      // 어댑터는 adaptee 객체를 가지고 있어야 함
      private LegacyPrinter legacyPrinter;
      
      // 생성자를 통해 adaptee 객체 주입
      public PrinterAdapter(LegacyPrinter printer) {
        this.legacyPrinter = printer;
      }
      
      @Override
      public void handleMessage(String message) {
        // 어댑터 패턴의 핵심: 
        // MessageHandler 인터페이스를 구현하지만, 내부적으로는 LegacyPrinter의 메소드 호출
        // 즉, handleMessage() -> printWithPrefix() 메소드로 변환
        legacyPrinter.printWithPrefix("MSG", message);
        
        // 추가로 UI에도 메시지 표시 (외부 클래스의 멤버에 접근)
        outputArea.append("[MSG] " + message + "\n");
      }
    }

    // 어댑터를 통해 레거시 프린터 등록
    // LegacyPrinter를 직접 사용하지 않고, MessageHandler 인터페이스로 추상화됨
    messageHandler = new PrinterAdapter(legacyPrinter);

    /**
     * 익명 내부 클래스 (Anonymous Inner Class) 예제
     * 
     * 특징:
     * 1. 이름이 없는 클래스로, 선언과 동시에 인스턴스 생성
     * 2. 단 하나의 객체만 생성할 수 있음
     * 3. 주로 인터페이스나 추상 클래스를 구현/상속하여 일회성으로 사용할 때 유용
     * 4. 이벤트 리스너 구현에 매우 자주 사용됨
     */
    sendButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String message = messageField.getText();
        if (!message.isEmpty()) {
          // 여기서 어댑터 패턴의 활용을 볼 수 있음:
          // 우리는 단순히 MessageHandler 인터페이스만 사용하지만,
          // 내부적으로는 LegacyPrinter의 메소드가 호출됨
          messageHandler.handleMessage(message);
          
          // 입력 필드 초기화
          messageField.setText("");
        } else {
          // ButtonAdapterExample.this는 외부 클래스의 인스턴스를 참조
          // 익명 클래스에서 외부 클래스의 멤버에 접근할 때 필요함
          JOptionPane.showMessageDialog(ButtonAdapterExample2.this,
                  "전송할 메시지를 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
  }

  public static void main(String[] args) {
    // Swing UI는 이벤트 디스패치 스레드에서 실행
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ButtonAdapterExample2().setVisible(true);
      }
    });
  }
}