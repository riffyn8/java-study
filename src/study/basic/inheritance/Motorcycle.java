package study.basic.inheritance;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, boolean hasSidecar) {
        super(brand);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void showInfo() {
        System.out.println("=== 오토바이 ===");
        super.showInfo();
        System.out.println("사이드카: " + (hasSidecar ? "있음" : "없음"));
    }

    public void wheelie() {
        if(speed > 30)
            System.out.println(brand + ": 윌리");
        else
            System.out.println("속도가 너무 낮습니다.");

    }
}
