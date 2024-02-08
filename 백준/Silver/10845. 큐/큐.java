import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" -> queue.add(Integer.parseInt(st.nextToken()));
                case "pop" -> {
                    try {
                        sb.append(queue.remove()).append("\n");
                    } catch (NoSuchElementException e) {
                        sb.append(-1).append("\n");
                    }
                } case "size" -> sb.append(queue.size()).append("\n");
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                case "front" -> {
                    if (!queue.isEmpty()) {
                        sb.append(queue.get(0)).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
                case "back" -> {
                    if (!queue.isEmpty()) {
                        sb.append(queue.get(queue.size() - 1)).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
