package study.basic.inheritance;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String brand, int numDoors) {
        super(brand);
        this.numDoors = numDoors;
    }

    @Override
    public void showInfo() {
        System.out.println("=== 자동차 ===");
        super.showInfo();
        System.out.println("문 개수: " + numDoors);
    }

    public void honk() {
        System.out.println(brand + ": 빵빵!");
    }
}
