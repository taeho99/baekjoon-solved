import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[size+1];
        for(int idx=1; idx<=size; idx++) {
            graph[idx] = new ArrayList<>();
        }

        String input;
        while (!(input = br.readLine()).equals("-1 -1")) {
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] score = new int[size+1];
        int minScore = Integer.MAX_VALUE;
        for(int idx=1; idx<=size; idx++) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[size+1];

            queue.add(new int[] {idx, 0});
            visited[idx] = true;

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                score[idx] = poll[1];

                for (int i : graph[poll[0]]) {
                    if (visited[i]) continue;

                    queue.add(new int[]{i, poll[1] + 1});
                    visited[i] = true;
                }
            }
            minScore = Math.min(score[idx], minScore);
        }

        int cnt = 0;
        for(int idx=1; idx<=size; idx++) {
            if(score[idx] == minScore) cnt++;
        }

        sb.append(minScore).append(' ').append(cnt).append('\n');
        for(int idx=1; idx<=size; idx++) {
            if(score[idx] == minScore) sb.append(idx).append(' ');
        }

        System.out.print(sb);
    }
}