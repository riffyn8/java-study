package study.basic.inheritance;

import static java.lang.Math.*;

public class Vehicle {
    protected String brand;
    protected int speed;

    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    public void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + "속도 증가: " + speed + "km/h");
    }

    public void brake(int amount) {
        speed = max(0, speed - amount);
        System.out.println(brand + "속도 감소: " + speed + "km/h");
    }

    public void stop() {
        speed = 0;
        System.out.println(brand + " 정지");
    }

    public void showInfo() {
        System.out.println("브랜드: " + brand);
        System.out.println("현재 속도: " + speed + "km/h");
    }
}

