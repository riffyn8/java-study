package datastructure.sequential;

import java.util.Arrays;

// 전치행렬 실습
public class TransposeMatrixTest {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 결과를 담을 동일한 크기의 배열 생성
        int[][] transposed = new int[3][3];

        // 전치행렬은 원본 행렬의 행과 열을 교환하는 것이므로,
        // matrix[i][j]의 값을 행과 열 인덱스가 반전된 transposed[j][i] 위치에 저장함. (i는 행, j는 열)
        // 예: i=0, j=1일 때, 원본의 matrix[0][1](값: 2)은 전치 행렬의 transposed[1][0] 위치로 이동함.
        // 인덱스가 (i, j) -> (j, i)로 바뀌면서 가로줄(행) 데이터가 세로줄(열) 데이터로 변환됨.
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                transposed[j][i] = matrix[i][j];
            }
        }

        System.out.println(Arrays.deepToString(transposed));
    }
}
