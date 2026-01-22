package study.basic.polymorphism;

public class StartGame {
    public static void main(String[] args) {
        // 1. 다형성을 이용한 배열 관리 (최상위 타입 Unit으로 묶기)
        Unit[] units = new Unit[3];
        units[0] = new Warrior("전사");
        units[1] = new Lumberjack("나무꾼");
        units[2] = new Berserker("광전사");

        System.out.println("=== 유닛 이동 ===");
        for(Unit unit : units){
            if(unit != null) unit.move();
        }

        System.out.println();

        System.out.println("=== 유닛별 기본 행동 ===");
        for(Unit unit : units){
            if(unit == null) continue;

            // 2. instanceof와 다운캐스팅 활용
            if(unit instanceof Hero){
                Hero hero = (Hero) unit;
                Berserker berserker = (Berserker) unit;
                hero.attack();
            } else if(unit instanceof Worker){
                Worker worker = (Worker) unit;
                worker.work();
            }
        }

        System.out.println();

        System.out.println("=== 스킬 사용 ===");
        for(Unit unit : units){
            if(unit == null) continue;
            
            unit.skill("광분화");
        }

    }
}
