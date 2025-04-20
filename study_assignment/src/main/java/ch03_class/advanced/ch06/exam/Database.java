package ch03_class.advanced.ch06.exam;

// 싱글톤패턴
public class Database {
    private String connection = "MySQL";

    // static 필드에 Database 인스턴스 생성 (싱글톤)
    private static Database database = new Database();

    // private 생성자
    private Database() {
    }

    // static 메소드로 유일 인스턴스 반환
    public static Database getInstance() {
        return database;
    }

    // DB 연결 메소드
    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    // DB 연결 종료 메소드
    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }

    // DB 연결 정보 반환 메소드
    public String getConnection() {
        return connection;
    }
}
