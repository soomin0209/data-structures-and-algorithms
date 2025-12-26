import java.util.Arrays;

public class BruteForce {

    public static void main(String[] args) {
        // 테스트용 입력값 설정
        int[] numbers = {2, 11, 7, 15};
        int target = 9; // 2 + 7 = 9, 인덱스 {0, 2} 반환

        int[] result = findPairs(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findPairs(int[] numbers, int target) {
        // 1.1 배열을 순회해서 첫 번째 수 선택
        for (int i = 0; i < numbers.length; i++) {
            // 1.1 배열의  첫 번째 요소부터 순차적으로 선택
            int num1 = numbers[i];  // 첫 번째 수 선택

            // 2. 두 번째 수 선택 및 검증단계
            // 2.1 첫 번째 수 다음 인덱스부터 배열 끝까지 순회해서 선택
            for (int j = i + 1; j < numbers.length; j++) {
                // 2.2 현재 선택된 두 수의 합이 target과 같은지 확인
                int num2 = numbers[j];  // 두 번째 수 선택
                if (num1 + num2 == target) {
                    // 2.3 target과 같다면 두 수의 인덱스를 반환
                    return new int[]{i, j};
                }
            }
        }

        // 3. 결과 반환 단계
        // 3.1 조합을 찾지 못한 경우 빈 배열을 반환
        return new int[]{};
    }
}
