package study.basic.polymorphism;

abstract class BaseUnit implements Unit {
    String name;

    BaseUnit(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println(name + "이(가) 이동합니다.");
    }

    @Override
    public void skill(String skillName) {
        System.out.println(name + "은(는) 아직 사용할 수 있는 스킬이 없습니다.");
    }
}
