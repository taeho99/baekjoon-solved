import java.util.*;
class Solution {
    boolean[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        graph = new boolean[n+1][n+1];
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires) {
            graph[wire[0]][wire[1]] = false;
            graph[wire[1]][wire[0]] = false;
            boolean[] visited = new boolean[n+1];
            int result1 = bfs(n, visited);
            int result2 = bfs(n, visited);
            answer = Math.min(answer, Math.abs(result1 - result2));
            graph[wire[0]][wire[1]] = true;
            graph[wire[1]][wire[0]] = true;
        }
        return answer;
    }
    
    int bfs(int n, boolean[] visited) {
        int cnt = 0;
        for(int start=1; start<=n; start++) {
            if(visited[start] || cnt != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            
            visited[start] = true;
            queue.add(start);
            
            while(!queue.isEmpty()) {
                int poll = queue.poll();
                cnt++;
                
                for(int next=1; next<=n; next++) {
                    if(graph[poll][next] && !visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return cnt;
    }
}