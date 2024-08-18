import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static final int[] dRow = {-1, 1, 0, 0};
    static final int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine().trim());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int totalTime = Integer.parseInt(st.nextToken());

            int maxRowSize = rowSize + 2*totalTime;
            int maxColSize = colSize + 2*totalTime;

            boolean[][] visited = new boolean[maxRowSize][maxColSize];
            PriorityQueue<Cell> pq = new PriorityQueue<>(
                    (o1, o2) -> Integer.compare(o2.time, o1.time)
            );

            for(int row=totalTime; row<totalTime+rowSize; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=totalTime; col<totalTime+colSize; col++) {
                    int inputTime = Integer.parseInt(st.nextToken());
                    if(inputTime == 0) continue;

                    visited[row][col] = true;
                    pq.add(new Cell(row, col, inputTime, inputTime * 2));
                }
            }

            for(int curTime=1; curTime<=totalTime; curTime++) {
                Queue<Cell> queue = new LinkedList<>();
                while(!pq.isEmpty()) {
                    Cell pollCell = pq.poll();
                    pollCell.leftTime--;
                    // 번식하기
                    if(pollCell.leftTime < pollCell.time) {
                        for(int dir=0; dir<4; dir++) {
                            int nRow = pollCell.row + dRow[dir];
                            int nCol = pollCell.col + dCol[dir];
                            if(visited[nRow][nCol]) continue;
                            visited[nRow][nCol] = true;
                            queue.add(new Cell(nRow, nCol, pollCell.time, pollCell.time * 2));
                        }
                    }
                    if(pollCell.leftTime != 0) queue.add(pollCell);
                }

                while(!queue.isEmpty()) pq.add(queue.poll());
            }

            sb.append(pq.size()).append('\n');
        }
        System.out.print(sb);
    }

    static class Cell {
        int row, col, time, leftTime;

        public Cell(int row, int col, int time, int leftTime) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.leftTime = leftTime;
        }
    }
}
