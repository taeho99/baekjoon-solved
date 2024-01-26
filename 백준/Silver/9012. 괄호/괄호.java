import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		for(int i=0; i<c;  i++) {
			boolean isVPS = true;
			String str = input.next();
			Stack<Character> s = new Stack<Character>();
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(')
					s.push(str.charAt(j));
				else {
					if(!s.empty()) {
						s.pop();
					} else {
						isVPS = false;
						break;
					}
				}
			}
			if(!s.empty())
				isVPS =  false;
			System.out.println(isVPS ? "YES" : "NO");
		}
		
		
	}

}
