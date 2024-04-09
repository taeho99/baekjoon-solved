import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while(t-- > 0) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) {
                queue.addLast(Integer.parseInt(s[1]));
            } else if (s[0].equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append('\n');
            } else if (s[0].equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (s[0].equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (s[0].equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append('\n');
            } else if (s[0].equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }
        System.out.print(sb);
    }
}
