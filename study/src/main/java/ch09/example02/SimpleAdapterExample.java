package ch09.example02;

public class SimpleAdapterExample {
  /**
   * 우리 시스템에서 사용하는 메시지 출력 인터페이스
   */
  public interface MessagePrinter {
    void printMessage(String message);
    void printError(String errorMessage);
  }

  /**
   * 우리 시스템의 기본 구현체
   */
  public static class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void printMessage(String message) {
      System.out.println("메시지: " + message);
    }

    @Override
    public void printError(String errorMessage) {
      System.err.println("오류: " + errorMessage);
    }
  }

  /**
   * 외부 로깅 시스템의 인터페이스 (호환되지 않음)
   */
  public interface Logger {
    void log(String level, String content);
  }

  /**
   * 외부 로깅 시스템 구현체
   */
  public static class FileLogger implements Logger {
    @Override
    public void log(String level, String content) {
      System.out.println("[" + level + "] " + content + " (파일에 기록됨)");
    }
  }

  /**
   * 메시지 관리 클래스
   */
  public static class MessageManager {
    private MessagePrinter messagePrinter;

    public MessageManager() {
      this.messagePrinter = new ConsoleMessagePrinter();
    }

    /**
     * 외부 로거를 우리 시스템에 맞게 변환하는 어댑터 내부 클래스
     */
    private class LoggerAdapter implements MessagePrinter {
      private Logger logger;

      public LoggerAdapter(Logger logger) {
        this.logger = logger;
      }

      @Override
      public void printMessage(String message) {
        // Logger의 메소드를 MessagePrinter 인터페이스에 맞게 변환
        logger.log("INFO", message);
      }

      @Override
      public void printError(String errorMessage) {
        // Logger의 메소드를 MessagePrinter 인터페이스에 맞게 변환
        logger.log("ERROR", errorMessage);
      }
    }

    /**
     * 외부 로거를 우리 시스템에 등록
     */
    public void useLogger(Logger externalLogger) {
      // 어댑터를 통해 외부 로거를 MessagePrinter로 변환
      this.messagePrinter = new LoggerAdapter(externalLogger);
      System.out.println("외부 로거가 시스템에 연결되었습니다.");
    }

    /**
     * 메시지 출력 메소드
     */
    public void showMessage(String message) {
      messagePrinter.printMessage(message);
    }

    /**
     * 오류 메시지 출력 메소드
     */
    public void showError(String error) {
      messagePrinter.printError(error);
    }
  }

}
