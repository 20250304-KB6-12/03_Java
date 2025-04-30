package todo.command;

// Command 인터페이스
public interface Command {
  void execute();
  void undo();
}
