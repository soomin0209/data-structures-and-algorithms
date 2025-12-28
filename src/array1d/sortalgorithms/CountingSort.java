package array1d.sortalgorithms;

public class CountingSort {

    // 배열 출력을 위한 유틸리티 메서드
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 예시 배열 [4, 1, 3, 1, 2]로 테스트
        int[] arr = {4, 1, 3, 1, 2};

        System.out.println("정렬 전 배열:");
        printArray(arr);

        // 계수 정렬 수행
        countingSort(arr);

        System.out.println("정렬 후 배열:");
        printArray(arr);
    }

    private static void countingSort(int[] arr) {
        // 1. 최댓값 찾기
        // - 원본 배열에서 최댓값을 찾습니다.
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        // 2. 카운팅 배열 생성 및 초기화
        // - 인덱스를 0부터 max까지 사용할 수 있도록 길이가 (max + 1)인 카운팅 배열을 생성합니다.
        int[] counts = new int[max + 1];

        //3. 숫자 세기
        // - 원본 배열을 순회하며 각 요소에 해당하는 카운팅 배열의 인덱스를 통해 값 증가시킵니다.
        for (int num : arr) {
            counts[num]++;
        }

        // 4. 결과 배열 생성
        // - 원본 배열과 같은 크기의 결과 배열을 생성합니다.
        // - 카운팅 배열을 0부터 max까지 순회하며, counts[i]에 기록된 횟수만큼 결과 배열에 i를 순서대로 채워 넣습니다.
        // - 이 과정에서 자동으로 정렬이 완료됩니다.
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (counts[i] > 0) {
                arr[index] = i;
                index++;
                counts[i]--;
            }
        }
    }
}
