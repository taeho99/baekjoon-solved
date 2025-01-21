import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int now = 1;
        for(int i=0; i<n; i++) {
            int waiting = Integer.parseInt(input[i]);
            if (now != waiting) {
                if (!stack.isEmpty() && now == stack.peek()) {
                    stack.pop();
                    now++;
                    i--;
                } else {
                    stack.push(waiting);
                }
            } else {
                now++;
            }
        }

        while(!stack.isEmpty()) {
            int pop = stack.pop();
            if(pop != now) {
                System.out.print("Sad");
                return;
            }
            now++;
        }
        System.out.print("Nice");
    }
}