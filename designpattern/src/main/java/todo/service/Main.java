package todo.service;

import todo.command.AddTaskCommand;
import todo.command.Command;
import todo.command.CommandInvoker;
import todo.command.DeleteTaskCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  // Receiver : 실제 작업 수행 객체
  private static TaskManager taskManager = new TaskManager();

  // Invoker : 명령 실행 요청 객체
  private static CommandInvoker invoker = new CommandInvoker();

  // 명령어와 실행 로직을 매핑하는 Map
  private static final Map<Pattern, Consumer<String>> commandHandlers
          = new HashMap<>();

  // static 초기화 블럭 : 프로그램 실행 시 static 필드 초기화 용도 블럭
  static{
    // 입력된 값이 "exit"와 일치한다면
    commandHandlers.put(Pattern.compile("^exit$"), (input) -> {
      System.out.println("프로그램을 종료합니다.");
      scanner.close();
      System.exit(0);
    });

    commandHandlers.put(Pattern.compile("^todo list$"), (input) -> {
      taskManager.listTasks();
    });

    commandHandlers.put(Pattern.compile("^todo undo$"), (input) -> {
      invoker.undoLastCommand();
    });

   commandHandlers.put(Pattern.compile("^todo add .*"), (input) -> {
      processAddCommand(input);
    });

   commandHandlers.put(Pattern.compile("^todo del .*"), (input) -> {
      processDeleteCommand(input);
    });


  }


  private static void processAddCommand(String input) {
    // "todo add <우선순위> <할일내용>" 파싱
    String[] parts = input.split(" ", 4);
    if (parts.length < 4) {
      System.out.println("명령어 형식이 잘못되었습니다. 사용법: todo add <우선순위(1-5)> <할일내용>");
      return;
    }

    try {
      int priority = Integer.parseInt(parts[2]);
      if (priority < 1 || priority > 5) {
        System.out.println("우선순위는 1부터 5까지의 숫자여야 합니다.");
        return;
      }

      String content = parts[3];
      Command addCommand = new AddTaskCommand(taskManager, priority, content);
      invoker.executeCommand(addCommand);
    } catch (NumberFormatException e) {
      System.out.println("우선순위는 숫자여야 합니다.");
    }
  }

  private static void processDeleteCommand(String input) {
    // "todo del <번호>" 파싱
    String[] parts = input.split(" ", 3);
    if (parts.length < 3) {
      System.out.println("명령어 형식이 잘못되었습니다. 사용법: todo del <번호>");
      return;
    }

    try {
      int index = Integer.parseInt(parts[2]) - 1; // 1부터 시작하는 번호를 0부터 시작하는 인덱스로 변환
      Command deleteCommand = new DeleteTaskCommand(taskManager, index);
      invoker.executeCommand(deleteCommand);
    } catch (NumberFormatException e) {
      System.out.println("삭제할 항목 번호는 숫자여야 합니다.");
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }



  public static void main(String[] args) {
    System.out.println("===== 할 일 관리 시스템(CMD) =====");
    System.out.println("추가 : todo add <우선순위(1~5)> <할일내용>");
    System.out.println("삭제 : todo del <번호>");
    System.out.println("목록 : todo list");
    System.out.println("실행 취소 : todo undo");
    System.out.println("종료 : exit");



    while (true) {
      System.out.print("\n명령어 입력 : ");
      String input = scanner.nextLine().trim();

      try {
        boolean commandFound = false; // 일치하는 명령어를 찾았는지 체크

        // 명령어 매핑 맵에서 입력된 명령어와 일치하는 명령을 처리
        for (Map.Entry<Pattern, Consumer<String>> entry : commandHandlers.entrySet()) {

          // 입력된 명령어 input이 Map의 Key(정규식)과 매칭되면
          if (entry.getKey().matcher(input).matches()) {
            entry.getValue().accept(input);
            commandFound = true; // 일치하는 명령어가 있었다
            break; // 추가 검색 X
          }
        }
        
        if(!commandFound) { // 일치하는 명령어가 없었을 경우
          System.out.println("알 수 없는 명령어 입니다. 지원하는 명령어를 작성하세요.");
        }

      } catch (Exception e){
        e.printStackTrace();
      }
    }


  }

}
