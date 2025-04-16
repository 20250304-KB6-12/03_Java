package ch05;

public class ArgTest {
  public static void main(String[] args) {
    System.out.println("args.length = " + args.length);

    for(String item : args) {
      System.out.println("item = " + item);
    }
  }
}
