package study.basic.polymorphism;

public class StandardDelivery extends Delivery {
    public StandardDelivery(String item, String address) {
        super(item, address);
    }

    @Override
    public int calculateFee() {
        return 3000;
    }

    @Override
    public int estimateDays() {
        return 3;
    }
}
