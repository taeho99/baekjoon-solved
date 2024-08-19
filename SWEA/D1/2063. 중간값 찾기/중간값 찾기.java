import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA.2063 중간값찾기
 *
 * 1. 수를 size개 입력받아 배열에 저장한다.
 * 2. 배열을 오름차순으로 정렬한다.
 * 3. size/2번 인덱스의 값이 중간값이므로 출력한다.
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 수를 size개 입력받아 배열에 저장한다.
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int idx=0; idx<size; idx++) {
			arr[idx] = sc.nextInt();
		}
		// 2. 배열을 오름차순으로 정렬한다.
		Arrays.sort(arr);
		// 3. size/2번 인덱스의 값이 중간값이므로 출력한다.
		System.out.println(arr[size/2]);
	}
}
