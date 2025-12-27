import java.util.Arrays;
import java.util.Scanner;

public class FindOptimalTemperature {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = scanner.nextInt();

        // T번 반복해서 각각의 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            // 1. 초기화 단계
            // 1.1. 용액의 개수 N과 온도 배열을 입력 받음
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            // 1.2. 온도 배열을 오름차순으로 정렬
            Arrays.sort(arr);

            // 1.3. 투포인터 변수 초기화
            int left = 0;
            int right = N - 1;

            // 1.4. 결과값 저장 변수 초기화
            int minSum = Integer.MAX_VALUE; // 0에 가장 가까운 두 용액의 합을 저장할 변수
            int result1 = 0;    // 첫 번째 용액의 온도
            int result2 = 0;    // 두 번째 용액의 온도

            // 2. 용액 탐색 단계
            // 2.1. 포인터가 만나기 전까지 반복
            while (left < right) {
                // 2.2. 현재 두 용액의 합을 계산
                int sum = arr[left] + arr[right];

                // 2.3. 현재 합의 절대값과 저장된 최소 합의 절대값을 비교
                // 2.3.1. 현재 합의 절대값이 저장된 최소 합의 절대값보다 작은 경우
                if (Math.abs(sum) < Math.abs(minSum)) {
                    // 현재 합을 최소합으로 저장
                    minSum = sum;
                    // 왼쪽 포인터가 가리키는 값을 첫 번째 용액으로 저장
                    result1 = arr[left];
                    // 오른쪽 포인터가 가리키는 값을 두 번째 용액으로 저장
                    result2 = arr[right];
                }

                // 2.3.2. 현재 합의 절대값이 저장된 최소 합의 절대값과 같은 경우
                else if (Math.abs(sum) == Math.abs(minSum)) {
                    // 왼쪽 포인터가 가리키는 값이 저장된 첫 번째 용액보다 작은 경우 업데이트
                    if (arr[left] < result1) {
                        // 현재 합을 최소합으로 저장
                        minSum = sum;
                        // 왼쪽 포인터가 가리키는 값을 첫 번째 용액으로 저장
                        result1 = arr[left];
                        // 오른쪽 포인터가 가리키는 값을 두 번째 용액으로 저장
                        result2 = arr[right];
                    }
                }

                // 2.4. 현재 합 크기에 따라서 포인터 이동
                if (sum > 0) {
                    // 현재 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 이동
                    right--;
                } else {
                    // 현재 합이 0보다 작거나 같으면 왼쪽 포인터를 오른쪽으로 이동
                    left++;
                }
            }

            // 3. 결과 반환 단계
            // 3.1. 두 용액은 이미 정렬된 배열에서 선택했으므로 자동으로 오름차순으로 출력이 됨
            System.out.println(result1 + " " + result2);
        }
    }
}
