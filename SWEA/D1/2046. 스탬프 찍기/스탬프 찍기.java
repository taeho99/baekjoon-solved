import java.util.Scanner;

/**
 * SWEA.2046 스탬프찍기
 * 
 * 1. 주어진 숫자만큼 while문 반복하여 '#' 출력한다.
 */
public class Solution {
	public static void main(String[] args) {
		int num = new Scanner(System.in).nextInt();
		// 1. 주어진 숫자만큼 while문 반복하여 '#' 출력한다.
		while(num-- > 0) {
			System.out.print('#');
		}
	}
}
