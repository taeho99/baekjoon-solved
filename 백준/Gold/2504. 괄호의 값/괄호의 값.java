import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int value = 1;
        int result = 0;
        for (int idx=0; idx<str.length(); idx++) {
            char ch = str.charAt(idx);

            if(ch == '(' || ch == '[') {
                value *= ch=='(' ? 2 : 3;
                stack.push(ch);
            } else {
                if(ch == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    } else if (str.charAt(idx-1) == '(') {
                        result += value;
                    }
                    stack.pop();
                    value /= 2;
                } else {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    } else if (str.charAt(idx-1) == '[') {
                        result += value;
                    }
                    stack.pop();
                    value /= 3;
                }
            }
        }
        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(result);
    }

}