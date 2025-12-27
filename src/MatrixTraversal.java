public class MatrixTraversal {

    public static void main(String[] args) {
        // 테스트용 행렬 입력
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("행 우선 순회 결과: ");
        rowMajorOrder(matrix);

        System.out.println("열 우선 순회 결과: ");
        columnMajorOrder(matrix);

        System.out.println("지그재그 순회 결과: ");
        zigzagMajorOrder(matrix);
    }

    private static void rowMajorOrder(int[][] matrix) {
        int rows = matrix.length;       // 행의 크기
        int cols = matrix[0].length;    // 열의 크기

        // 1. 행 반복문과 열 반복문을 중첩해서 순회
        // 1.1. 행 인덱스 i는 0부터 행의 크기 - 1 까지 반복
        for (int i = 0; i < rows; i++) {
            // 1.2. 열 인덱스 j는 0부터 열의 크기 - 1 까지 반복
            for (int j = 0; j < cols; j++) {
                // 2. 현재 위치(i, j)로 원소에 접근
                System.out.print(matrix[i][j] + " ");
            }
            // 3. 다음 행으로 이동하여 반복
            // 3.1. 현재 행의 순회가 끝나면 다음 행으로 이동 및 개행 출력
            System.out.println();
        }
    }

    private static void columnMajorOrder(int[][] matrix) {
        int rows = matrix.length;       // 행의 크기
        int cols = matrix[0].length;    // 열의 크기

        // 1. 행 반복문과 열 반복문을 중첩해서 순회
        // 1.1. 열 인덱스 j는 0부터 열의 크기 - 1 까지 반복
        for (int j = 0; j < cols; j++) {
            // 1.2. 행 인덱스 i는 0부터 행의 크기 - 1 까지 반복
            for (int i = 0; i < rows; i++) {
                // 2. 현재 위치(i, j)로 원소에 접근
                System.out.print(matrix[i][j] + " ");
            }
            // 3. 다음 열로 이동하여 반복
            // 3.1. 현재 열의 순회가 끝나면 다음 열으로 이동 및 개행 출력
            System.out.println();
        }
    }

    private static void zigzagMajorOrder(int[][] matrix) {
        int rows = matrix.length;       // 행의 크기
        int cols = matrix[0].length;    // 열의 크기

        // 1. 행 반복문과 열 반복문을 중첩해서 순회
        // 1.1. 행 인덱스 i는 0부터 행의 크기 - 1 까지 반복
        for (int i = 0; i < rows; i++) {
            // 1.2. 행 인덱스가(i)가 짝수인 경우: 왼쪽에서 오른쪽으로 순회
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {    // 짝수행: j를 0부터 열의 크기 - 1 까지 증가
                    // 2. 현재 위치(i, j)로 원소에 접근
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                // 1.3. 행 인덱스(i)가 홀수인 경우: 오른쪽에서 왼쪽으로 순회
                for (int j = cols-1; j >= 0; j--) { // 홀수행: j를 열의 크기 - 1 부터 0까지 감소
                    // 2. 현재 위치(i, j)로 원소에 접근
                    System.out.print(matrix[i][j] + " ");
                }
            }
            // 3. 다음 행으로 이동하여 반복
            // 3.1. 현재 행의 순회가 끝나면 다음 행으로 이동 및 개행 출력
            System.out.println();
        }
    }
}
