import java.util.Scanner;

public class DeltaSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 초기화 단계
        // 1.1. 격자 크기 N과 NxN 행렬을 입력 받음
        int N = scanner.nextInt();
        int[][] grid = new int[N][N];

        // NxN 격자 데이터를 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 1.2. 특정 위치 (x, y) 입력 받기
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // 1.3. 델타 배열(방향 배열) 초기화
        // dx, dy: 상하좌우 방향을 나타내는 배열
        int[] dx = {0, 0, -1, 1};   // 상하좌우 열 방향 (x축)
        int[] dy = {-1, 1, 0, 0};   // 상하좌우 행 방향 (y축)
        // 대각선 포함
        //int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
        //int[] dy = {-1, 1, 0, 0, 1, -1, 1, -1};

        // 1.4. 결과값 저장 변수 초기화
        int sum = 0;

        // 2. 숫자 합 계산 단계
        // 2.1. 4방향 순회
        for (int i = 0; i < dx.length; i++) {
            // 2.1.1. 새로운 좌표 계산
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 2.1.2. 새로운 좌표의 유효성 체크
            // - 새로운 좌표가 격자 범위 (즉, 인덱스 범위 내) 있는지 체크
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                sum += grid[ny][nx];
            }
        }

        // 3. 결과 반환 단계
        // 3.1. sum 출력
        System.out.println(sum);
    }
}
