import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(true) {
            String str = input.nextLine();
            if (str.equals("."))
                break;
            Stack<Character> s = new Stack<>();

            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(' || c == '[') {
                    s.push(c);
                } else if (c == ')') {
                    if (!s.empty() && s.peek() == '(')
                        s.pop();
                    else {
                        s.push(c);
                        break;
                    }
                } else if (c == ']') {
                    if (!s.empty() && s.peek() == '[')
                        s.pop();
                    else {
                        s.push(c);
                        break;
                    }
                }
            }

            System.out.println((s.size() == 0) ? "yes" : "no");
        }
    }
}
