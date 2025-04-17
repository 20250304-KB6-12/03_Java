package ch07.sec12;

public class Cat extends Animal {

  public Cat() {
    name = "나비";
  }

  @Override
  public void sound() {
    System.out.println(name + " : 야옹, 하악, 골골");
  }
}
