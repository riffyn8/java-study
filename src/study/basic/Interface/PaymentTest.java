package study.basic.Interface;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor[] processors = {
                new CreditCardProcessor("9495889393200000"),
                new SimplePayProcessor("user1", 100000)
        };

        int[] amounts = {50000, 30000};

        System.out.println("=== 결제 시스템 테스트 ===\n");

        for(int i=0; i< processors.length; i++) {
            System.out.println("--- 결제 " + (i + 1) + " ---");

            if(processors[i].processPayment(amounts[i]))
                processors[i].printReceipt();

            System.out.println();
        }
    }
}
