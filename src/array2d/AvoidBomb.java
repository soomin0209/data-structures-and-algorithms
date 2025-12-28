package array2d;

import java.util.Scanner;

public class AvoidBomb {

    public static void main(String[] args) {
        // 1. 초기화 단계
        // 1.1. 입력 받기
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // 테스트 케이스 수

        for (int tc = 0; tc < T; tc++) {
            int N = scanner.nextInt();  // 보드의 크기
            int[][] board = new int[N][N];

            // 각 보드 상태를 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }

            // 1.2. 방문 체크를 위한 visited 배열 생성
            boolean[][] visited = new boolean[N][N];

            // 1.3. 델타 배열 정의
            int[] dx = {0, 0, -1, 1};   // 상하좌우 열 방향
            int[] dy = {-1, 1, 0, 0};   // 상하좌우 행 방향

            // 1.4. 안전한 칸 카운트 변수 초기화
            int safeCount = N * N;

            // 2. 공격 범위 체크 단계
            // 2.1. 보드의 모든 칸을 순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 폭탄을 발견한 경우 처리
                    if (board[i][j] == 1) {
                        // 현재 폭탄 위치를 방문 처리 및 safeCount값 감소
                        // 방문하지 않은 경우만 처리
                        if (!visited[i][j]) {
                            visited[i][j] = true;
                            safeCount--;
                        }

                        // 2.2. 현재 폭탄 위치에서 4방향 탐색 시작
                        for (int d = 0; d < 4; d++) {
                            // 새 좌표 초기화
                            int nx = j, ny = i;

                            // 각 방향으로 끝까지 탐색
                            while (true) {
                                // 새 좌표 계산
                                nx += dx[d];
                                ny += dy[d];

                                // 2.2.1. 다음 위치가 보드 범위를 벗어났는지 확인
                                // 벗어난 경우 탐색 종료
                                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                                // 2.2.2. 아직 방문하지 않은 칸이면 방문 처리
                                // 현재 폭탄 위치를 방문 처리 및 safeCount값 감소
                                // 방문하지 않은 경우만 처리
                                if (!visited[ny][nx]) {
                                    visited[ny][nx] = true;
                                    safeCount--;
                                }
                            }
                        }
                    }
                }
            }

            // 3. 결과 출력 단계
            // 3.1. 안전한 칸 개수를 출력
            System.out.println(safeCount);
        }
    }
}
