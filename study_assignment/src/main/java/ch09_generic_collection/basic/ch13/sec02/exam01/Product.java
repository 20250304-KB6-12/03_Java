package ch09_generic_collection.basic.ch13.sec02.exam01;

public class Product<K, M> {
    /*
    * 멤버변수 kind, model을 제너릭으로 운영
    * 각각의 멤버에 대해 Getter, Setter 메서드를 직접 정의(Lombok 사용불가)
    * */

    //타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M model;
    //타입 파라미터를 리턴 타입과 매개 변수 타입으로 사용
    public K getKind() { return this.kind; }
    public M getModel() { return this.model; }
    public void setKind(K kind) { this.kind = kind; }
    public void setModel(M model) { this.model = model; }
}
