package array1d.searchmethod;

public class SequentialSearch {

    public static void main(String[] args) {
        // 테스트를 위한 예제 배열과 찾을 값 설정
        int[] arr = {4, 2, 7, 1, 9, 3};
        int target = 7;

        // 순차 탐색 수행 및 결과 출력
        int result = sequentialSearch(arr, target);
        if (result != -1) {
            System.out.println("찾은 위치: " + result);
        } else {
            System.out.println("값을 찾지 못했습니다.");
        }
    }

    public static int sequentialSearch(int[] arr, int target) {
        // 1. 배열의 첫 번째 요소부터 시작
        // 1-1. 배열을 순차적으로 탐색하기 위한 반복문 시작
        for (int i = 0; i < arr.length; i++) {
            // 1-2. 현재 인덱스의 요소에 접근

            // 2. 찾고자 하는 값(target)과 현재 요소 비교
            // 2-1. target과 현재 요소가 일치하면, 현재 인덱스 반환
            if (arr[i] == target) {
                return i;
            }
            // 2-2. 일치하지 않으면, 다음 인덱스로 이동하여 1-2부터 반복
        }

        // 3. 배열 탐색 완료 후 결과 처리
        // 3-1. 배열 끝까지 탐색했는데 찾지 못한 경우 실패(-1) 반환
        return -1;
    }
}
