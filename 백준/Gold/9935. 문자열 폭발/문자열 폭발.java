import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : str) {
            stack.push(c);

            if (stack.size() >= bomb.length) {
                int sameCount = 0;
                for (int idx = 0; idx < bomb.length; idx++) {
                    if (stack.get(stack.size() - bomb.length + idx) == bomb[idx]) sameCount++;
                }
                if (sameCount == bomb.length) {
                    for (int idx = 0; idx < bomb.length; idx++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}