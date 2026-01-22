package study.basic.polymorphism;

abstract class Hero extends BaseUnit{

    Hero(String name) {
        super(name);
    }

    public abstract void attack();
}
