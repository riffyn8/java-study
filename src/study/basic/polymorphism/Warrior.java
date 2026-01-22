package study.basic.polymorphism;

public class Warrior extends Hero{

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println(name + "이(가) 칼을 휘두릅니다.");
    }
}
