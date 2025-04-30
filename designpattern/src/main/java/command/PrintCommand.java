package command;

public class PrintCommand implements Command {

  @Override
  public void execute() {
    System.out.println("===================");
    System.out.println("Print Command");
    System.out.println("===================");
    System.out.println();
  }
}
