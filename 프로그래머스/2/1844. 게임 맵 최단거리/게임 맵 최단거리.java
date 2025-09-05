import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        int rowSize = maps.length;
        int colSize = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];
        
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if(poll[0] == rowSize-1 && poll[1] == colSize-1) {
                return poll[2] + 1;
            }
            
            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];
                
                if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize) continue;
                if(maps[nRow][nCol] == 0 || visited[nRow][nCol]) continue;
                
                queue.add(new int[] {nRow, nCol, poll[2] + 1});
                visited[nRow][nCol] = true;
            }
        }
        return -1;
    }
}