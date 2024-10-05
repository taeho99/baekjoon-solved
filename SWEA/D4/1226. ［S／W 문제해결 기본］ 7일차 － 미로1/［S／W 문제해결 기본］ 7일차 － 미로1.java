import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int[][] map;
    static int startRow, startCol;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for(int tc=1; tc<=T; tc++) {
            br.readLine();
            sb.append('#').append(tc).append(' ');

            map = new int[16][16];
            for(int row=0; row<16; row++) {
                String tmp = br.readLine();
                for(int col=0; col<16; col++) {
                    map[row][col] = tmp.charAt(col) - '0';
                    if(map[row][col] == 2) {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            sb.append(bfs() ? "1" : "0").append('\n');

        }
        System.out.print(sb);
    }

    private static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[16][16];

        queue.add(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            if(map[poll[0]][poll[1]] == 3) {
                return true;
            }

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow < 0 || nRow >= 16 || nCol < 0 || nCol >= 16 || visited[nRow][nCol] || map[nRow][nCol] == 1) continue;

                queue.add(new int[] {nRow, nCol});
                visited[nRow][nCol] = true;
            }
        }
        return false;
    }
}