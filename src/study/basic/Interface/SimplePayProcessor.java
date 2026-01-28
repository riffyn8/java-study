package study.basic.Interface;

public class SimplePayProcessor implements PaymentProcessor {
    private String userId;
    private int balance;
    private int amount;

    public SimplePayProcessor(String userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }

    @Override
    public boolean validate() {
        return userId != null && !userId.isEmpty();
    }

    @Override
    public boolean processPayment(int amount) {
        if(!validate()) {
            System.out.println("사용자 검증 실패");
            return false;
        }

        if(balance < amount) {
            System.out.println("잔액 부족 (잔액: " + String.format("%,d", balance) + "원)");
            return false;
        }

        this.amount = amount;
        balance -= amount;
        System.out.println("간편결제 완료: " + String.format("%,d", amount) + "원");

        return true;
    }

    @Override
    public void printReceipt() {
        System.out.println("--- 간편결제 영수증 ---");
        System.out.println("사용자: " + userId);
        System.out.println("금액: " + String.format("%,d", amount) + "원");
        System.out.println("잔액: " + String.format("%,d", balance) + "원");
    }
}

