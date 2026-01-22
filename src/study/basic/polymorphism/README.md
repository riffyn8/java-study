## 다형성 기초 실습

### 1. 개요
자바의 다형성 개념을 이해하기 위해 상속 계층 구조를 설계하고, 부모 타입의 참조변수로 다양한 자식 인스턴스를 제어하는 프로젝트입니다.

### 2. 학습 핵심 포인트
- **업캐스팅(Up-casting)** : `Unit` 인터페이스 타입의 배열에 `Warrior`, `Lumberjack`, `Berserker` 인터페이스를 담아 공통적으로 관리
- **추상 클래스를 통한 중복 제거** : `BaseUnit`을 추가하여 `Hero`와 `Worker`가 공통으로 가지는 `name` 필드와 `move()`, `skill()` 메서드의 중복을 방지
- **오버라이딩** : 최상위 인터페이스에 정의된 `skill()` 메서드를 자식 클래스에서 각자의 특성에 맞게 재정의 할 수 있음
- 다운캐스팅(Down-casting) : `Unit` 인터페이스로 묶었지만, 각 클래스만의 고유 기능을 사용하기 위해 다운캐스팅이 필요함. 이때 `instanceof` 연산자로 다운캐스팅 가능한 타입인지 확인을 해줘야함

### 3. 클래스 구조

<img width="359" height="586" alt="Image" src="https://github.com/user-attachments/assets/ea6319b5-4fa3-4bbf-b2ea-d537fb7a7c7e" />

- Unit(Interface) : 최상위 규격
- BaseUnit(Abstract Class) : 공통 속성 관리
  - Hero(Abstract Class) : 용사 그룹의 부모 
    - Warrior : 전사 기본 행동
      - Berserker : 전사의 다른 직업
  - Worker(Abstract Class) : 일꾼 그룹의 부모
    - Lumberjack : 나무꾼




