import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int idx=0; idx<n; idx++) {
            if(visited[idx]) continue;
            answer++;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(idx);
            visited[idx] = true;
            
            while(!queue.isEmpty()) {
                int poll = queue.poll();
                
                for(int next=0; next<n; next++) {
                    if(computers[poll][next] == 1 && !visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return answer;
    }
}