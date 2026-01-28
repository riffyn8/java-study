## 🚗 Java 상속(Inheritance) 실습
이 프로젝트는 Vehicle 클래스를 중심으로 상속의 구조와 자식 클래스에서의 기능 확장을 실습


### 1. 클래스 다이어그램
<img width="446" height="451" alt="Image" src="https://github.com/user-attachments/assets/c8f5bd9d-fa1b-4de9-81bc-843a9b7d6876" />

### 2. 핵심 설계 구조
- **부모 클래스 (Vehicle)**: 모든 탈것의 공통 속성(brand, speed)과 동작(accelerate, brake, stop, showInfo)을 정의
- **자식 클래스 (Car, Motorcycle)**: 부모의 기능을 상속받음과 동시에, 각 객체의 특성에 맞는 고유 기능을 추가하거나 메서드 오버라이딩을 통해 동작을 재정의

### 3. 클래스별 상세 기능

| 클래스 | 주요 특징 및 확장 기능  |
|-----|----------------|
|Vehicle (부모)|공통 속성 및 기본 주행 로직 관리|
|Car (자식)|numDoors(문 개수) 속성 추가 및 honk()(경적) 기능 구현|
|Motorcycle (자식)|hasSidecar(사이드카 여부) 속성 추가 및 wheelie()(묘기) 기능 구현|

### 4. 주요 학습 포인트
- **super()**: 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출하여 초기화를 진행
- **오버라이딩**: showInfo()를 자식에 맞게 구현부 수정
- **접근 제어자**: 부모 클래스의 멤버변수를 protected로 선언하여 자식 클래스에서 접근 가능 

