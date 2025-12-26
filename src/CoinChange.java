import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coins = {500, 100, 50, 10};

        // 거스름돈 금액 입력 받기
        int target = scanner.nextInt();

        // 결과 출력
        System.out.println("그리디 알고리즘: " + coinChangeByGreedyAlgorithm(coins, target));
        System.out.println("완전탐색: " + coinChangeByBruteForce(coins, target));
    }

    private static int coinChangeByGreedyAlgorithm(int[] coins, int target) {
        // 1. 초기화 단계
        // 1.1 동전을 큰 단위부터 작은 단위 순으로 정렬
        Arrays.sort(coins);

        // 1.2 거스름돈 금액을 저장할 변수 초기화
        int remainingAmount = target;
        // 1.3 사용된 동전 개수를 저장할 변수 초기화
        int coinCount = 0;

        // 2. 큰 동전부터 사용하는 단계
        // 2.1 가장 큰 단위의 동전부터 순차적으로 진행
        for (int i = coins.length-1; i >= 0; i--) {
            // 2.2 현재 동전으로 거스름돈을 최대한 많이 거슬러줌
            coinCount += remainingAmount / coins[i];    // 현재 동전으로 거슬러 줄 수 있는 개수
            remainingAmount %= coins[i];                // 남은 금액 계산
        }

        // 3. 결과 반환 단계
        // 3.1 사용된 동전 개수 반환
        return coinCount;
    }

    private static int coinChangeByBruteForce(int[] coins, int target) {
        // 1. 초기화 단계
        // 1.1 각 동전별로 사용 가능한 최대 개수 계산
        int[] maxCounts = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            maxCounts[i] = target / coins[i];
        }

        // 1.2 최소 동전 개수를 저장한 변수를 최댓값으로 초기화
        int minCoins = Integer.MAX_VALUE;

        // 2. 모든 조합 시도 단계
        // 2.1 500원을 0개부터 최대 개수까지 반복
        for (int i = 0; i <= maxCounts[0]; i++) {
            // 2.2 100원을 0개부터 최대 개수까지 반복
            for (int j = 0; j <= maxCounts[1]; j++) {
                // 2.3 50원을 0개부터 최대 개수까지 반복
                for (int k = 0; k <= maxCounts[2]; k++) {
                    // 2.4 10원을 0개부터 최대 개수까지 반복
                    for (int l = 0; l <= maxCounts[3]; l++) {
                        // 각 조합에 대해 현재 조합으로 만들어지는 총 금액 계산
                        int currentSum = coins[0]*i + coins[1]*j + coins[2]*k + coins[3]*l;

                        // 목표 금액과 일치하는지 확인
                        if (currentSum == target) {
                            // 일치하면 사용된 동전 개수와 현재 최소값과 비교하여 갱신
                            minCoins = Math.min(minCoins, i + j + k + l);
                        }
                    }
                }
            }
        }

        // 1260 → 500(2) + 100(2) + 50(1) + 10(1) → 6개
        // 3. 결과 반환 단계
        // 3.1 찾은 동전 개수를 반환
        // 3.2 해를 찾지 못한 경우 -1 반환
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
