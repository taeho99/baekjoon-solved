import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int idx=1; idx<=n; idx++) {
            deque.addLast(idx);
        }
        while (true) {
            sb.append(deque.pollFirst()).append(' ');
            if(deque.isEmpty()) break;
            deque.addLast(deque.pollFirst());
        }
        System.out.print(sb);
    }
}