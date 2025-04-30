package command;

import java.util.Scanner;

public class ExitCommand implements Command {

  @Override
  public void execute() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("종료할까요? (Y/n) : ");
    String answer = scanner.nextLine();

    if (answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
      scanner.close();
      System.exit(0);
    }
  }
}
