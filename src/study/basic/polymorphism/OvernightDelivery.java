package study.basic.polymorphism;

public class OvernightDelivery extends Delivery {
    public OvernightDelivery(String item, String address) {
        super(item, address);
    }

    @Override
    public int calculateFee() {
        return 10000;
    }

    @Override
    public int estimateDays() {
        return 0;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("당일 배송 상품입니다.");
    }
}
