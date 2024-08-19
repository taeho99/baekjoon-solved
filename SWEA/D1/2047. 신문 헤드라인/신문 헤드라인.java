import java.util.Scanner;

/**
 * SWEA.2047 신문헤드라인
 *  
 * 1. 헤드라인 문자열을 입력받는다.
 * 2. char[] 배열로 변환 후 반복문을 돌며 현재 글자가 소문자인 경우 대문자로 변환하여 결과 문자열에 추가한다.
 * 3. 소문자 알파벳이 아닌 경우 기존 문자를 그대로 결과 문자열에 출력한다.
 * 4. 결과 문자열을 출력한다.
 */
public class Solution {

	public static void main(String[] args) {
		// 1. 헤드라인 문자열을 입력받는다.
		String headLine = new Scanner(System.in).nextLine();
		String result = "";
		// 2. char[] 배열로 변환 후 반복문을 돌며 현재 글자가 소문자인 경우 대문자로 변환하여 결과 문자열에 추가한다.
		for(char ch : headLine.toCharArray()) {
			if(Character.isLowerCase(ch)) 
				result += Character.toUpperCase(ch); 
			// 3. 소문자 알파벳이 아닌 경우 기존 문자를 그대로 결과 문자열에 출력한다.
			else
				result += ch;
		}
		// 4. 결과 문자열을 출력한다.
		System.out.println(result);
	}

}
