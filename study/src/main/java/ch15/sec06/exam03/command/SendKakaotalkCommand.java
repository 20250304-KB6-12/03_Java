package ch15.sec06.exam03.command;

import ch15.sec06.exam03.Message;

public class SendKakaotalkCommand implements Command {

  @Override
  public void execute(Message message) {
    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
  }
}
