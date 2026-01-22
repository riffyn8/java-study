package study.basic.polymorphism;

abstract class Worker extends BaseUnit{
    Worker(String name) {
        super(name);
    }

    public abstract void work();
}
