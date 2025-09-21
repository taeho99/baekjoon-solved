import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int idx=1; idx<=n; idx++) {
            graph[idx] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        queue.add(new int[] {1, 0});
        visited[1] = true;
        
        int max = 0;
        int sum = 0;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if(poll[1] > max) {
                sum = 1;
                max = poll[1];
            } else if (poll[1] == max) {
                sum++;
            }
            
            for(int next : graph[poll[0]]) {
                if(visited[next]) continue;
                queue.add(new int[] {next, poll[1]+1});
                visited[next] = true;
            }
        }
        
        return sum;
    }
}