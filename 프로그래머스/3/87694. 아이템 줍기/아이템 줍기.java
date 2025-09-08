import java.util.*;
class Solution {
    int size = 102;
    int[] dRow = {-1, 1, 0, 0};
    int[] dCol = {0, 0, -1, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] board = new boolean[size][size];
        boolean[][] filled = new boolean[size][size];
        
        for(int[] r : rectangle) {
            int col1 = r[0] * 2;
            int row1 = r[1] * 2;
            int col2 = r[2] * 2;
            int row2 = r[3] * 2;
            
            for(int row=row1; row<=row2; row++) {
                for(int col=col1; col<=col2; col++) {
                    filled[row][col] = true;
                }
            }
        }
        
        for(int[] r : rectangle) {
            int col1 = r[0] * 2;
            int row1 = r[1] * 2;
            int col2 = r[2] * 2;
            int row2 = r[3] * 2;
            
            for(int row=row1+1; row<=row2-1; row++) {
                for(int col=col1+1; col<=col2-1; col++) {
                    filled[row][col] = false;
                }
            }
        }
        
        for(int row=1; row<size-1; row++) {
            for(int col=1; col<size-1; col++) {
                if(!filled[row][col]) continue;
                if(!filled[row-1][col] || !filled[row+1][col] || !filled[row][col-1] || !filled[row][col+1]) {
                    board[row][col] = true;
                }
            }
        }
        
        int startRow = characterY*2, startCol = characterX*2;
        int endRow = itemY*2, endCol = itemX*2;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[size][size];
        
        int answer = 0;
        queue.add(new int[] {startRow, startCol, 0});
        visited[startRow][startCol] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if(poll[0] == endRow && poll[1] == endCol) {
                answer = poll[2];
                break;
            }
            
            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];
                
                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
                if(visited[nRow][nCol]) continue;
                
                if(board[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[] {nRow, nCol, poll[2]+1});
                }
            }
        }
        
        return answer/2;
    }
}