package ch15.sec06.exam03;

import ch15.sec06.exam03.command.Command;
import ch15.sec06.exam03.command.SendKakaotalkCommand;
import ch15.sec06.exam03.command.SendMailCommand;
import ch15.sec06.exam03.command.SendSMSCommand;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Map<String, Command> commands = new LinkedHashMap<>();
		commands.put("sendMail", new SendMailCommand());
		commands.put("sendKakaotalk",new SendKakaotalkCommand());
		commands.put("sendSMS",new SendSMSCommand());

		//Queue 컬렉션 생성
		Queue<Message> messageQueue = new LinkedList<>();
		
		//메시지 넣기
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "감자바"));
		
		//메시지를 하나씩 꺼내어 처리
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			Command command = commands.get(message.command);
			if(command != null) {
				command.execute(message);
			}
		}
	}
}
