package study.basic.Interface;

public class CreditCardProcessor implements PaymentProcessor, PointEarnable {
    private String cardNumber;
    private int amount;
    private int points;

    public CreditCardProcessor(String cardNumbers) {
        this.cardNumber = cardNumbers;
    }

    @Override
    public boolean validate() {
        return cardNumber != null && cardNumber.length() == 16;
    }

    @Override
    public boolean processPayment(int amount) {
        if(!validate()) {
            System.out.println("카드 검증 실패");
            return false;
        }

        this.amount = amount;
        this.points = calculatePoints(amount);
        System.out.println("카드 결제 완료: " + String.format("%,d", amount) + "원");
        earnPoints();
        return true;
    }

    @Override
    public void printReceipt() {
        System.out.println("--- 카드 결제 영수증 ---");
        System.out.println("카드: ****-****-****-" + cardNumber.substring(12));
        System.out.println("금액: " + String.format("%,d", amount) + "원");
        System.out.println("적립: " + points + "P");
    }

    @Override
    public int calculatePoints(int amount) {
        return (int)(amount * 0.1);
    }

    @Override
    public void earnPoints() {
        System.out.println(points + "포인트 적립!");
    }
}
