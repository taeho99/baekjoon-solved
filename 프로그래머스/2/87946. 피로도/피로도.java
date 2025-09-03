import java.util.*;
class Solution {
    int answer = 0;
    int[] selectList;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        selectList = new int[dungeons.length];
        visited = new boolean[dungeons.length];
        permutation(0, k, dungeons);
        return answer;
    }
    
    void permutation(int depth, int k, int[][] dungeons) {
        if(depth == dungeons.length) {
            answer = Math.max(game(k, dungeons), answer);
            return;
        }
        
        for(int idx=0; idx<dungeons.length; idx++) {
            if(visited[idx]) continue;
            visited[idx] = true;
            selectList[depth] = idx;
            permutation(depth+1, k, dungeons);
            visited[idx] = false;
        }
    }
    
    int game(int health, int[][] dungeons) {
        int cnt = 0;
        for(int idx=0; idx<dungeons.length; idx++) {
            if(health >= dungeons[selectList[idx]][0]) {
                health -= dungeons[selectList[idx]][1];
                cnt++;
            } else break;
        }
        return cnt;
    }
}