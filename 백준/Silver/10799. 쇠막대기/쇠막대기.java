import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int result = 0;
		for(int idx=0; idx<chars.length; idx++) {
			if (chars[idx] == '(') {
				stack.push(chars[idx]);
			} else {
				stack.pop();
				if (chars[idx-1] == '(') {
					result += stack.size();
				} else {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}