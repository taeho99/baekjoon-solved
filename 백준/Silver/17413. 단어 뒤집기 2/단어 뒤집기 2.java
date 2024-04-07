import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        boolean isTag = false;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '<') isTag = true;

            if(isTag) {
                sb.append(c);
            } else {
                Stack<Character> stack = new Stack<>();
                while(i != (s.length() - 1) && s.charAt(i+1) != '<') {
                    stack.push(s.charAt(i++));
                }
                stack.push(s.charAt(i));
                StringBuilder tmp = new StringBuilder();
                while(!stack.isEmpty()) {
                    tmp.append(stack.pop());
                }
                String[] split = tmp.toString().split(" ");
                for(int j=split.length - 1; j>=0; j--) {
                    sb.append(split[j]);
                    if(j != 0) sb.append(' ');
                }
            }

            if(c == '>') isTag = false;
        }
        System.out.println(sb);
    }
}
