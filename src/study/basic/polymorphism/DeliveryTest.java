package study.basic.polymorphism;

public class DeliveryTest{
    public static void main(String[] args) {
        Delivery[] deliveries ={
                new StandardDelivery("Java 책", "서울시 강남구"),
                new ExpressDelivery("노트북", "부산시 해운대구"),
                new OvernightDelivery("긴급 서류", "대전시 유성구"),
        };

        System.out.println("배송 시스템 테스트 \n");

        int totalFee = 0;

        for(Delivery delivery : deliveries){
            delivery.printInfo();
            totalFee += delivery.calculateFee();
            System.out.println();
        }

        System.out.println("===================");
        System.out.println("총 배송비: " + String.format("%,d", totalFee) + "원");
    }
}
