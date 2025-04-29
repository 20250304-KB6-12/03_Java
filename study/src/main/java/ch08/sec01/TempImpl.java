package ch08.sec01;

public class TempImpl implements Temp {
    private String name;
    
    public TempImpl(String name) {
        this.name = name;
    }
    
    @Override
    public void process() {
        System.out.println("처리 중...");
    }
    
    @Override
    public String getName() {
        return name != null ? name : DEFAULT_NAME;
    }
    
    @Override
    public int calculate(int x, int y) {
        return x + y;
    }
    
    // 디폴트 메서드도 필요시 재정의할 수 있음
    @Override
    public void printInfo() {
        System.out.println("=== 사용자 정의 정보 ===");
        System.out.println("이름: " + getName());
    }



}