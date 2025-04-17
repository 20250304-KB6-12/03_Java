package ch6.sec14;

public class Car {
  // 필드 선언
  private int speed;
  private boolean stop;

  /* 생성자 자동 완성  : alt + insert -> 생성자 선택 */
  // 생성자
  public Car() { // 기본 생성자
  }

  public Car(int speed, boolean stop) { // 매개변수 있는 생성자
    this.speed = speed;
    this.stop = stop;
  }

  // 오버로딩 성립(순서 다르게)
  public Car(boolean stop, int speed) { // 매개변수 있는 생성자
    this.speed = speed;
    this.stop = stop;
  }


  /* getter/setter 자동 완성 : alt + insert -> getter 및 setter */
  // getter/setter
  public int getSpeed() {
    System.out.println("stop = "+ isStop());
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public boolean isStop() {
    return stop;
  }

  public void setStop(boolean stop) {
    this.stop = stop;
  }
}
