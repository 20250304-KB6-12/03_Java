package command;

import java.io.File;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    FileService fs = new FileService();

    Command[] commands = {
      //new AddCommand(),
      // Command 함수형 인터페이스가 제공하는 메서드 void execute()와 같은 형태의 람다식
      () -> System.out.println("Add Command"), // 매개변수 X, 반환값 X

      //new OpenCommand(),
      // Command 함수형 인터페이스가 제공하는 메서드 void execute()와 같은 모양의 fs.open() 참조
      // 기존 메서드 : void open()
      // 람다식 : () -> fs.open()
      fs::open,

      //new PrintCommand(),
      // Command 함수형 인터페이스가 제공하는 메서드 void execute()와 같은 모양의 fs.print() 참조
      // 기존 메서드 : void print()
      // 람다식 : () -> fs.print()
      fs::print,


      //new ExitCommand()
      // Command 함수형 인터페이스가 제공하는 메서드 void execute()와 같은 모양 메서드 Main.exit() 참조
      // 기존 메서드 : static void exit()
      // 람다식 : () -> Main.exit()
      Main::exit
    };

    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("1: Add, 2: Open, 3: Print, 4: Exit");
      System.out.print(" ");
      System.out.print("선택 : ");
      int sel = scanner.nextInt();

      commands[sel-1].execute();
    }
  }


  public static void exit(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("종료할까요? (Y/n) : ");
    String answer = scanner.nextLine();

    if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
      scanner.close();
      System.exit(0);
    }
  }
}
