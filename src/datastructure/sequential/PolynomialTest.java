package datastructure.sequential;

/*
A(x) =        4x^3 + 3x^2 + 5x
B(x) = 3X^4 +  x^3 +        2x + 1

C(x) = 3x^4 + 5x^3 + 3x^2 + 7x + 1

A(x)와 B(x)의 각 항을 비교하여 지수가 같은 항이 있으면 계수를 더하여 만든 항을 다항식 C(x)의 항으로 추가하고,
지수가 같은 항이 없으면 그대로 C(x)의 항으로 추가한다.

*/

class Polynomial {
    private int degree; // 최고 차수(지수)
    private float coef[] = new float[20]; //  계수들을 저장할 배열(이하 coef)

    // 최고 차수, 계수들을 저장할 배열을 초기화 생성자
    Polynomial(int degree, float coef[]) {
        this.degree = degree;
        this.coef = coef;
    }

    // 최고 차수만큼 coef의 i번째를 0으로 초기화
    // 0이 아닌 null과 연산을 했을 경우 에러가 발생하기 때문.
    public Polynomial(int degree) {
        this.degree = degree;
        for(int i=0; i<degree; i++){
            this.coef[i] = 0;
        }
    }

    // 최고 차수가 몇인지 반환
    public int getDegree() {
        return degree;
    }

    // coef i번째 값을 반환
    public float getCoef(int i) {
        return this.coef[i];
    }

    // coef의 i번째 값을 셋팅
    public float setCoef(int i, float coef) {
        return this.coef[i] = coef;
    }

    // coef에 저장된 값들을 출력
    public void printPoly() {
        // 객체의 원본 degree를 보호하기 위해 지역 변수 temp에 복사하여 사용
        int temp = this.degree;

        // 인덱스 0부터 차례대로 출력하되, 지수는 최고 차수부터 하나씩 감소 (내림차순)
        for(int i=0; i<=this.degree; i++){
            // coef[i]는 계수, temp는 해당 항의 지수를 의미
            System.out.printf("%3.0fx^%d", this.coef[i], temp--);
        }
        System.out.println();
    }
}

class OperatePoly {
    // degree = 다항식의 최소 차수, index = 계수가 저장된 배열의 index
    private int degree_A=0, degree_B=0, degree_C=0, index_A=0, index_B=0, index_C=0;
    private int expo_A, expo_B, expo_C; // 각 항의 지수

    public Polynomial addPoly(Polynomial A, Polynomial B) {
        degree_A = A.getDegree();
        degree_B = B.getDegree();
        expo_A = degree_A;
        expo_B = degree_B;

        // 두 다항식 중 높은 차수를 C(x)의 차수로 결정
        if(degree_A >= degree_B)
            degree_C=degree_A;
        else
            degree_C=degree_B;

        Polynomial C = new Polynomial(degree_C);

        // 두 다항식 중 어느 하나라도 모든 항을 검사할 때까지 반복(최고 차수부터 상수항까지)
        // 배열의 마지막 인덱스(degree)에 도달하면 해당 다항식의 처리는 완료됨
        // 후위 연산자를 사용하기 때문에, 현재 위치의 값을 먼저 참조한 뒤 인덱스를 갱신하는 것
        while(index_A <= degree_A && index_B <= degree_B) {
            if(expo_A > expo_B) {
                // A(x)의 현재 항의 차수가 더 클 경우
                // B(x)에는 해당 차수의 항이 없으므로, A(x)의 계수만 C(x)에 저장
                // 저장 후 A(x)의 인덱스를 증가시켜 다음 항으로 이동하고, 비교 대상 차수(expo_A)를 한 단계 낮춤
                C.setCoef(index_C++, A.getCoef(index_A++));
                expo_A--;
            } else if(expo_A == expo_B) {
                // A(x)와 B(x)의 차수가 동일한 경우
                // 동류항이므로 두 계수를 합산하여 C(x)에 저장
                C.setCoef(index_C++, A.getCoef(index_A++)+B.getCoef(index_B++));
                expo_A--;
                expo_B--;
            } else {
                // B(x)의 현재 항의 차수가 더 클 경우
                C.setCoef(index_C++, B.getCoef(index_B++));
                expo_B--;
            }
        }

        return C;
    }
}

public class PolynomialTest {
    public static void main(String[] args){
        float a[] = new float[] {4, 3, 5, 0};
        float b[] = new float[] {3, 1, 0, 2, 1};

        Polynomial A = new Polynomial(3, a);
        Polynomial B = new Polynomial(4, b);

        OperatePoly optPoly = new OperatePoly();

        Polynomial C = optPoly.addPoly(A, B);

        System.out.printf("A(x)=");
        A.printPoly();

        System.out.printf("B(x)=");
        B.printPoly();

        System.out.printf("C(x)=");
        C.printPoly();
    }
}
