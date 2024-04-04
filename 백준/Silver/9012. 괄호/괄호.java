import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String s = br.readLine();
            sb.append(isVPS(s) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isVPS(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
