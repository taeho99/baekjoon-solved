import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while(size-- > 0) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int highest = stack.pop();
        int result = 1;
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            if(pop > highest) {
                result++;
                highest = pop;
            }
        }
        System.out.print(result);
    }
}