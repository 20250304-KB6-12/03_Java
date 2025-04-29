package ch14.ex00;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Player implements Runnable{
  private String name;

  private final Random random = new Random();

  @Override
  public void run() {
    try{
      int curr = Main.count;
      Thread.sleep(random.nextInt(5) * 200 + 1000);

      while(curr != Main.count){
        Thread.sleep(1000);
        curr = Main.count;
      }

      synchronized (Main.class) {

        int callNumber = ++Main.count;
        System.out.printf("%-10s : %2d\n", name, callNumber);

        if (callNumber == Main.finalNumber) {
          System.out.println(name + " 벌칙 당첨!");
        }
      }
    }catch (InterruptedException e){
      Thread.currentThread().interrupt();
      System.err.println(name + "의 스레드가 중단되었습니다: " + e.getMessage());

    }

  }
}
