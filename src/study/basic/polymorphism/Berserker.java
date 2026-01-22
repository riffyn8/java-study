package study.basic.polymorphism;

public class Berserker extends Warrior {

    public Berserker(String name) {
        super(name);
    }

    @Override
    public void skill(String skillName) {
        switch(skillName) {
            case "광분화" :
                berserk();
                break;
        }
    }

    public void berserk() {
        System.out.println(name + "이(가) 광분화를 사용합니다");
    }
}
