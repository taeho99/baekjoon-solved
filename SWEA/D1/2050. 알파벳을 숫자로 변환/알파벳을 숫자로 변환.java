import java.util.Scanner;

/**
 * SWEA.2050 알파벳을숫자로변환
 * 
 * 1. 알파벳(대문자)로 이루어진 문자열을 입력받는다.
 * 2. 문자열을 char[] 배열로 변환 후 한글자씩 (ch - 'A' + 1)을 출력한다.
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 알파벳(대문자)로 이루어진 문자열을 입력받는다.
		String alphabet = sc.nextLine();
		// 2. 문자열을 char[] 배열로 변환 후 한글자씩 (ch - 'A' + 1)을 출력한다.
		for(char ch : alphabet.toCharArray()) {
			System.out.print((ch-'A'+1) + " ");
		}
	}
}
