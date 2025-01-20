import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<=n; idx++) {
            deque.addLast(new int[]{idx, Integer.parseInt(st.nextToken())});
        }

        int[] poll = deque.pollFirst();
        sb.append(poll[0]).append(' ');
        while (!deque.isEmpty()) {
            if (poll[1] > 0) {
                while (poll[1]-- > 1) {
                    deque.addLast(deque.pollFirst());
                }
                poll = deque.pollFirst();
                sb.append(poll[0]).append(' ');
            } else {
                while (poll[1]++ < -1) {
                    deque.addFirst(deque.pollLast());
                }
                poll = deque.pollLast();
                sb.append(poll[0]).append(' ');
            }
        }

        System.out.print(sb);
    }
}