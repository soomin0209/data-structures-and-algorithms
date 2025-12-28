package array1d.searchmethod;

import java.util.Arrays;

public class TwoPointer {

    public static void main(String[] args) {
        // 1. 두 수의 합이 특정 값이 되는 쌍 찾기
        // 테스트를 위한 예제 배열과 목표 합 설정
        int[] arr1 = {4, 1, 8, 7, 3, 2};  // 정렬되지 않은 배열
        int target1 = 10;  // 찾고자 하는 합

        // 투 포인터 탐색 수행 및 결과 출력
        System.out.println("1. 두 수의 합이 특정 값이 되는 쌍 찾기");
        System.out.println("원본 배열: " + Arrays.toString(arr1));
        System.out.println("목표 합: " + target1);
        boolean result1 = findTwoSum(arr1, target1);
        System.out.println("합이 " + target1 + "이 되는 두 수가 " +
                (result1 ? "존재합니다.\n" : "존재하지 않습니다.\n"));


        // 2. 연속 부분 수열의 합
        // 테스트를 위한 예제 배열과 목표 합 설정
        int[] arr2 = {1, 2, 3, 1, 2};  // 예시 배열
        int target2 = 3;         // 목표값

        // 입력 데이터 출력
        System.out.println("\n2. 연속 부분 수열의 합");
        System.out.println("원본 배열: " + Arrays.toString(arr2));
        System.out.println("목표 합: " + target2);

        // 결과 계산 및 출력
        int result2 = findExactSum(arr2, target2);
        System.out.println("합이 정확히 " + target2 + "인 연속된 구간의 개수: " + result2);

        // 모든 가능한 구간 출력 (설명을 위한 추가 코드)
        System.out.println("\n만족하는 구간들:");
        for (int i = 0; i < arr2.length; i++) {
            int sum = 0;
            for (int j = i; j < arr2.length; j++) {
                sum += arr2[j];
                if (sum == target2) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr2, i, j + 1))
                            + " (합: " + sum + ")");
                }
            }
        }
    }

    private static boolean findTwoSum(int[] arr, int target) {
        // 1. 포인터 초기화
        // 1.1. left 포인터는 배열의 첫 번째 인덱스로 설정
        // 1.2. right 포인터는 배열의 마지막 인덱스로 설정
        int left = 0;
        int right = arr.length - 1;

        // 2. 두 포인터가 교차하기 전까지 반복
        while (left < right) {
            // 2.1. 현재 두 포인터가 가리키는 값의 합 계산
            int sum = arr[left] + arr[right];

            // 2.2. 합과 목표값 비교
            // 3. 합과 목표값 비교 후 포인터 이동
            // 3.1. 합이 목표값과 같으면 true 반환
            if (sum == target) {
                System.out.println("찾은 두 수: " + arr[left] + ", " + arr[right]);
                return true;
            }
            // 3.2. 합이 목표값보다 작으면 left 포인터를 오른쪽으로 이동
            else if (sum < target) {
                left++;
            }
            // 3.3. 합이 목표값보다 크면 right 포인터를 왼쪽으로 이동
            else {
                right--;
            }
        }

        // 4. 탐색 완료 후 결과 처리
        // 4.1. 목표값을 만드는 쌍을 찾지 못한 경우 false 반환
        return false;
    }

    private static int findExactSum(int[] arr, int target) {
        // 1. 포인터와 현재 합계, 결과값 초기화
        // 1.1. start 포인터는 배열의 첫 번째 인덱스로 설정
        // 1.2. end 포인터는 배열의 두 번째 인덱스로 설정
        int start = 0;
        int end = 1;

        // 1.3. 현재까지의 합을 첫 번째 원소로 초기화
        // - 초기 구간은 첫 번째 원소만 가리킴
        // - start 포인터 이상 end 포인터 미만까지의 합
        int currentSum = arr[0];

        // 1.4. 찾은 구간의 개수를 초기화
        int count = 0;

        // 2. 구간 탐색
        // - 배열의 모든 구간을 확인할 때까지 반복
        while (start < arr.length) {
            // 2.1. 현재 구간의 합이 정확히 target과 일치하는 경우
            if (currentSum == target) {
                // count 증가
                count++;

                // end가 배열의 끝에 도달하지 않은 경우
                if (end < arr.length) {
                    // 구간을 확장하기 위해 end 위치에 원소를 더하고 end 증가
                    currentSum += arr[end++];
                } else {
                    // 더 이상 구간을 확장할 수 없으므로 start를 이동
                    currentSum -= arr[start++];
                }
            }
            // 2.2. end가 배열 끝에 도달하지 않았고, 현재 합이 target보다 작은 경우
            else if (end < arr.length && currentSum < target) {
                // 구간을 확장하기 위해 end 위치에 원소를 더하고 end 증가
                currentSum += arr[end++];
            }
            // 2.3. end가 배열 끝에 도달했거나 현재 합이 target보다 큰 경우
            else {
                // 더 이상 구간을 확장할 수 없으므로 start를 이동
                currentSum -= arr[start++];
            }
        }

        // 3. 탐색 완료 후 결과 처리
        // 3.1. 찾은 구간의 개수 반환
        return count;
    }
}
