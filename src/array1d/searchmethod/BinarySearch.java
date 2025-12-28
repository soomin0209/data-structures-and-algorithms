package array1d.searchmethod;

public class BinarySearch {

    static int cnt = 0;

    public static void main(String[] args) {
        // 테스트를 위한 정렬된 예제 배열과 찾을 값 설정
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //정렬된 배열이어야 함
        int target = 7;
        cnt = 0;

        // 이진 탐색 수행 및 결과 출력
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("찾은 위치: " + result);
            System.out.println("검색 횟수: " + cnt);
        } else {
            System.out.println("값을 찾지 못했습니다.");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        // 1. 탐색 범위의 시작점과 끝점을 설정
        // 1.1. left는 배열의 첫번째 인덱스로 설정
        // 1.2. right는 배열의 마지막 인덱스로 설정
        int left = 0;
        int right = arr.length - 1;

        // 2. 탐색 범위가 유효한 동안 반복
        while (left <= right) {
            // 2.1. 중간 위치 계산
            int mid = (left + right) / 2;
            cnt++;

            // 3. 중간 값과 target값 비교 후 처리
            // 3.1. 중간 값이 target과 같으면 해당 인덱스(mid) 반환
            if (arr[mid] == target) {
                return mid;
            }
            // 3.2. 중간 값이 target보다 크면 오른쪽 범위를 줄임
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            // 3.3. 중간 값이 target보다 작으면 왼쪽 범위를 줄임
            else {
                left = mid + 1;
            }
        }

        // 4. 탐색 완료 후 결과 처리
        // 4.1. 찾지 못한 경우 실패(-1) 반환
        return -1;
    }
}
