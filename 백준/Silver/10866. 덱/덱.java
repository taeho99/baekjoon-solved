import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opt = st.nextToken();
            switch (opt) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.pollFirst());
                    sb.append('\n');
                    break;
                case "pop_back":
                    if(deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.pollLast());
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    if(deque.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if(deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.peekFirst());
                    sb.append('\n');
                    break;
                case "back":
                    if(deque.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(deque.peekLast());
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
