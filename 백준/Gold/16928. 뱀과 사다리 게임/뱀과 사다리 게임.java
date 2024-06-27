import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        for(int i=1; i<=100; i++) {
            board[i] = i;
        }

        for(int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            if(poll == 100) {
                System.out.println(visited[100]);
                return;
            }
            
            for(int i=1; i<=6; i++) {
                int nextNode = poll + i;
                if(nextNode > 100) continue;
                if(visited[board[nextNode]] == 0) {
                    queue.add(board[nextNode]);
                    visited[board[nextNode]] = visited[poll] + 1;
                }
            }
        }
    }
}
