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

        int[] type = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(type[i] == 1) continue;
            queue.addFirst(tmp);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            queue.addLast(Integer.parseInt(st.nextToken()));
            sb.append(queue.pollFirst()).append(' ');
        }
        System.out.print(sb);
    }
}
