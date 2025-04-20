package ch03_class.basic.ch06.sec14;

public class Car {

    // 필드 선언
    private int speed;
    private boolean stop;

    // speed 필드의 Getter
    public int getSpeed() {
        return speed;
    }

    // speed 필드의 Setter
    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
            return;
        } else {
            this.speed = speed;
        }
    }

    // stop 필드의 Getter
    public boolean isStop() {
        return stop;
    }

    // stop 필드의 Setter - 자동차가 멈추면 속도도 0으로 설정
    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) {
            this.speed = 0;
        }
    }
}
