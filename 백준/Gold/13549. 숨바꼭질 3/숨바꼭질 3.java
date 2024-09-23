import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX+1];

        queue.add(new int[] {start, 0});

        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            visited[poll[0]] = true;

            if(poll[0] == end) {
                min = Math.min(min, poll[1]);
            }

            if(poll[0] - 1 >= 0 && !visited[poll[0]-1]) queue.add(new int[] {poll[0]-1, poll[1]+1});
            if(poll[0] + 1 <= MAX && !visited[poll[0]+1]) queue.add(new int[] {poll[0]+1, poll[1]+1});
            if(poll[0] * 2 <= MAX && !visited[poll[0]*2]) queue.add(new int[] {poll[0]*2, poll[1]});
        }
        System.out.println(min);
    }
}