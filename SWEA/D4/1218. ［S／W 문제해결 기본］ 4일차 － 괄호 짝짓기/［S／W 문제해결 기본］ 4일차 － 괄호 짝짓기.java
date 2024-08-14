import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * SWEA.1218 괄호 짝짓기 (스택으로 풀이) 
 *
 * 1. 총 10개의 테스트케이스가 주어진다.
 * 2. 괄호 문자의 길이와 괄호로 이루어진 문자열이 주어진다.
 * 3. 괄호는 4종류로 '()', '[]', '{}', '<>'가 있다.
 * 4. 스택으로 괄호의 짝이 맞는지 판단한다.
 * 	4-1. 여는 괄호일 경우 각 스택에 PUSH 한다.
 * 	4-2. 닫는 괄호일 경우
 * 	 4-2-1. 스택에 괄호가 없으면 짝이 안맞으므로 유효X
 *	 4-2-2. 직전 입력된 괄호가 짝이 맞는지 확인한다. 짝이 안맞으면 유효X
 *	 4-2-3. 짝이 맞으면 스택에서 열린 괄호를 POP 한다.
 * 5. 만약 짝이 모두 맞다면 스택이 비어있어야 한다. 스택이 비어있지 않으면 유효X
 * 6. valid 여부를 출력한다.
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1. 총 10개의 테스트케이스가 주어진다.
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 2. 괄호 문자의 길이와 괄호로 이루어진 문자열이 주어진다.
			int length = Integer.parseInt(br.readLine());
			// 3. 괄호는 4종류로 '()', '[]', '{}', '<>'가 있다.
			String str = br.readLine();
			
			boolean valid = true; //유효성 여부
			
			// 4. 스택으로 괄호의 짝이 맞는지 판단한다.
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for(char ch : str.toCharArray()) {
				// 4-1. 여는 괄호일 경우 각 스택에 PUSH 한다.
				if(ch == '(' || ch == '[' || ch == '{' || ch == '<') {
					stack.push(ch);
				} 
				// 4-2. 닫는 괄호일 경우
				else {
					// 4-2-1. 스택에 괄호가 없으면 짝이 안맞으므로 유효X
					if(stack.isEmpty()) {
						valid = false;
						break;
					}
					
					switch(ch) {
					case ')':
						// 4-2-2. 직전 입력된 괄호가 짝이 맞는지 확인한다. 짝이 안맞으면 유효X
						if(stack.peek() != '(') {
							valid = false;
							break;
						} 
						// 4-2-3. 짝이 맞으면 스택에서 열린 괄호를 POP 한다.
						else {
							stack.pop();
						}
						break;
					case ']':
						// 4-2-2. 직전 입력된 괄호가 짝이 맞는지 확인한다. 짝이 안맞으면 유효X
						if(stack.peek() != '[') {
							valid = false;
							break;
						} 
						// 4-2-3. 짝이 맞으면 스택에서 열린 괄호를 POP 한다.
						else {
							stack.pop();
						}
						break;
					case '}':
						// 4-2-2. 직전 입력된 괄호가 짝이 맞는지 확인한다. 짝이 안맞으면 유효X
						if(stack.peek() != '{') {
							valid = false;
							break;
						} 
						// 4-2-3. 짝이 맞으면 스택에서 열린 괄호를 POP 한다.
						else {
							stack.pop();
						}
						break;
					case '>':
						// 4-2-2. 직전 입력된 괄호가 짝이 맞는지 확인한다. 짝이 안맞으면 유효X
						if(stack.peek() != '<') {
							valid = false;
							break;
						} 
						// 4-2-3. 짝이 맞으면 스택에서 열린 괄호를 POP 한다.
						else {
							stack.pop();
						}
						break;
					}
				}
			}
			// 5. 만약 짝이 모두 맞다면 스택이 비어있어야 한다. 스택이 비어있지 않으면 유효X
			if(!stack.isEmpty()) valid = false;
			// 6. valid 여부를 출력한다.
			sb.append(valid ? 1 : 0).append('\n');
		}
		System.out.print(sb);
	}

}
