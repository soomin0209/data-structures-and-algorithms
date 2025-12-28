public class SnailTraversal {

    public static void main(String[] args) {
        // 예시 행렬 (3x4 행렬)
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        printSnailOrder(matrix);
    }

    private static void printSnailOrder(int[][] matrix) {
        int N = matrix.length;  // 행의 크기
        int M = matrix[0].length;   // 열의 크기
        boolean[][] visited = new boolean[N][M];    // 각 원소의 방문 여부 확인

        // 1. 방향 설정을 위한 델타 배열 정의
        // 우, 하, 좌, 상 순서로 델타 배열을 생성
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int x = 0, y = 0;   // 현재 위치
        int dir = 0; // 현재 방향 (0: 우, 1: 하, 2: 좌, 3: 상)

        // 모든 원소를 방문할 때까지 3단계 반복
        for (int i = 0; i < N * M; i++) {
            // 2. 현재 위치에서 이동처리
            // 2.1. 현재 위치 방문 및 방문 처리
            System.out.print(matrix[y][x] + " ");
            visited[y][x] = true;

            // 2.2. 현재 방향(dir)에 따라 다음 위치를 계산
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // 2.3. 다음 위치에 대한 유효성 확인 (배열 범위 내 & 미방문)
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextY][nextX]) {
                // 방향 전환 후 새로운 좌표 얻기
                dir = (dir + 1) % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }

            // 유효하다면 다음 위치로 이동
            x = nextX;
            y = nextY;
        }
    }
}
