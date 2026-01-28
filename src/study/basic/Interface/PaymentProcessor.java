package study.basic.Interface;

public interface PaymentProcessor {
    boolean validate();
    boolean processPayment(int amount);
    void printReceipt();

    default void refund(int amount) {
        System.out.println(String.format("%,d", amount) + "원 환불 처리됨");
    }
}
