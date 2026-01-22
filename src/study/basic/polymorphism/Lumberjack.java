package study.basic.polymorphism;

public class Lumberjack extends Worker {

    Lumberjack(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + "이(가) 나무를 벱니다");
    }
}
