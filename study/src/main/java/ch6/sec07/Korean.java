package ch6.sec07;

public class Korean {

  // 필드 선언
  String nation = "대한민국"; // 명시적 초기화
  String name;
  String ssn;

  /* 생성자 자동 완성 방법 : alt + insert -> 생성자 선택 */

  public Korean(String nation, String name, String ssn) {
    this.nation = nation;
    this.name = name;
    this.ssn = ssn;
  }
}
