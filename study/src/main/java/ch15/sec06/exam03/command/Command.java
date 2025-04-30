package ch15.sec06.exam03.command;

import ch15.sec06.exam03.Message;

public interface Command {
  void execute(Message message);
}
