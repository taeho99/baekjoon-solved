import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCase = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=totalCase; testCase++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			int sum = 0;
			
			for(int idx=0; idx<input.length(); idx++) {
				char ch = input.charAt(idx);
				if(ch == '(') {
					stack.push(ch);
				} else if (ch == ')') {
					stack.pop();
					if(input.charAt(idx-1) == '(') {
						sum += stack.size();
					} else {
						sum ++;
					}
				}
			}
			System.out.println("#" + testCase + " " + sum);
		}
	}

}
