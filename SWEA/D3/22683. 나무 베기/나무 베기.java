import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int size, maxCutTreeCnt, minResult;
    static char[][] map;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static List<int[]> trees;
    static Car start;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            maxCutTreeCnt = Integer.parseInt(st.nextToken());

            map = new char[size][size];
            trees = new ArrayList<>();
            for(int row=0; row<size; row++) {
                String tmp = br.readLine();
                for(int col=0; col<size; col++) {
                    map[row][col] = tmp.charAt(col);
                    if(map[row][col] == 'T') trees.add(new int[] {row, col});
                    else if(map[row][col] == 'X') {
                        start = new Car(row, col, 0, 0, 0);
                    }
                }
            }

            minResult = Integer.MAX_VALUE;
            bfs();

            sb.append(minResult == Integer.MAX_VALUE ? -1 : minResult).append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs() {
        PriorityQueue<Car> queue = new PriorityQueue<>();
        boolean[][][][] visited = new boolean[size][size][maxCutTreeCnt+1][4];

        queue.add(start);
        visited[start.row][start.col][start.cutCnt][0] = true;

        while(!queue.isEmpty()) {
            Car poll = queue.poll();

            if(map[poll.row][poll.col] == 'Y') {
                minResult = Math.min(minResult, poll.cnt);
                continue;
            }

            for(int d=(poll.head-1); d<=(poll.head+2); d++) {
                int dir = (d + 4) % 4;
                int nRow = poll.row + dRow[dir];
                int nCol = poll.col + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

                int nCnt = poll.cnt + Math.abs(poll.head-d) + 1;
                int nCutCnt = poll.cutCnt;
                if(map[nRow][nCol] == 'T') {
                    if(poll.cutCnt + 1 <= maxCutTreeCnt) nCutCnt++;
                    else continue;
                }

                if(visited[nRow][nCol][nCutCnt][dir]) continue;

                queue.add(new Car(nRow, nCol, dir, nCnt, nCutCnt));
                visited[nRow][nCol][nCutCnt][dir] = true;
            }
        }
    }

    static class Car implements Comparable<Car> {
        int row, col, head, cnt, cutCnt;

        public Car(int row, int col, int head, int cnt, int cutCnt) {
            this.row = row;
            this.col = col;
            this.head = head;
            this.cnt = cnt;
            this.cutCnt = cutCnt;
        }

        @Override
        public int compareTo(Car o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}