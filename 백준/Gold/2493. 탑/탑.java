import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()) {
                sb.append('0').append(' ');
                stack.push(new Tower(i, height));
            } else {
                while(true) {
                    if (stack.isEmpty()) {
                        sb.append('0').append(' ');
                        stack.push(new Tower(i, height));
                        break;
                    }

                    if(stack.peek().height > height) {
                        sb.append(stack.peek().idx).append(' ');
                        stack.push(new Tower(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class Tower {
        int idx, height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}
