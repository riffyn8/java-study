package study.basic.polymorphism;

public abstract class Delivery {
    protected String item;
    protected String address;

    public Delivery(String item, String address) {
        this.item = item;
        this.address = address;
    }

    public abstract int calculateFee();
    public abstract int estimateDays();

    public void printInfo() {
        System.out.println("=== 배송 정보 ===");
        System.out.println("상품: " + item);
        System.out.println("주소: " + address);
        System.out.println("배송비: " + String.format("%,d", calculateFee()) + "원");
        System.out.println("예상 소요일: " + estimateDays() + "일");
    }
}
