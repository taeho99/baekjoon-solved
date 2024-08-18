import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * SWEA.5653 줄기 세포 배양
 *
 * 1. 초기 줄기세포의 가로, 세로 사이즈와 배양 시간을 입력받는다.
 *      1-1. 배양 후 최대 가로, 세로 사이즈는 (초기 사이즈 + 배양시간 * 2)이다.
 * 2. 생명력이 높은 순으로 배양하기 위해 우선순위 큐를 사용한다.
 *      2-1. 우선순위 큐에는 활성+비활성 상태의 줄기 세포가 저장된다.
 * 3. 배양 여부를 확인하기 위해 visited[][] 배열을 사용한다.
 * 4. 초기 줄기 세포를 입력받는다. time은 생명력이며 leftTime은 (활성시간+비활성시간)이다.
 *      4-1. 0이 입력된 경우 체크하지 않는다.
 *      4-2. 0이 아닌 경우 배양 여부를 true로 바구고 우선순위 큐에 넣는다.
 * 5. 1초부터 totalTime까지 배양 시간을 증가시키며 줄기 세포를 배양시킨다.
 *      5-1. 가장 생명력이 높은 줄기 세포부터 꺼내 남은 생명력을 감소시킨다.
 *      5-2. 활성 상태(남은 생명력 < 생명력)이면 번식시킨다.
 *          5-2-1. 이미 번식이 된 위치면 번식하지 않는다.
 *          5-2-2. 번식한 줄기 세포의 배양 여부를 체크하고 임시로 큐에 저장한다.
 *      5-3. 기존의 줄기 세포 중 죽지 않은 세포(남은생명력 != 0)를 임시로 큐에 저장한다.
 *      5-4. 임시 큐에서 우선순위 큐로 모든 활성+비활성 세포를 옮긴다.
 * 6. 우선순위 큐에는 활성+비활성 상태의 줄기 세포가 저장되므로 우선순위 큐의 size를 출력한다.
 */
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

            // 1. 초기 줄기세포의 가로, 세로 사이즈와 배양 시간을 입력받는다.
            st = new StringTokenizer(br.readLine().trim());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int totalTime = Integer.parseInt(st.nextToken());

            // 1-1. 배양 후 최대 가로, 세로 사이즈는 (초기 사이즈 + 배양시간 * 2)이다.
            int maxRowSize = rowSize + 2 * totalTime;
            int maxColSize = colSize + 2 * totalTime;

            // 2. 생명력이 높은 순으로 배양하기 위해 우선순위 큐를 사용한다.
            // 2-1. 우선순위 큐에는 활성+비활성 상태의 줄기 세포가 저장된다.
            PriorityQueue<Cell> pq = new PriorityQueue<>(
                    (o1, o2) -> Integer.compare(o2.time, o1.time)
            );
            // 3. 배양 여부를 확인하기 위해 visited[][] 배열을 사용한다.
            boolean[][] visited = new boolean[maxRowSize][maxColSize];

            // 4. 초기 줄기 세포를 입력받는다. Cell의 time은 생명력이며 leftTime은 (활성시간+비활성시간)이다.
            for(int row=totalTime; row<totalTime+rowSize; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=totalTime; col<totalTime+colSize; col++) {
                    int inputTime = Integer.parseInt(st.nextToken());
                    // 4-1. 0이 입력된 경우 체크하지 않는다.
                    if(inputTime == 0) continue;

                    // 4-2. 0이 아닌 경우 배양 여부를 true로 바구고 우선순위 큐에 넣는다.
                    visited[row][col] = true;
                    pq.add(new Cell(row, col, inputTime, inputTime * 2));
                }
            }

            // 5. 1초부터 totalTime까지 배양 시간을 증가시키며 줄기 세포를 배양시킨다.
            for(int curTime=1; curTime<=totalTime; curTime++) {
                Queue<Cell> queue = new LinkedList<>();
                while(!pq.isEmpty()) {
                    // 5-1. 가장 생명력이 높은 줄기 세포부터 꺼내 남은 생명력을 감소시킨다.
                    Cell pollCell = pq.poll();
                    pollCell.leftTime--;

                    // 5-2. 활성 상태(남은 생명력 < 생명력)이면 번식시킨다.
                    if(pollCell.leftTime < pollCell.time) {
                        for(int dir=0; dir<4; dir++) {
                            int nRow = pollCell.row + dRow[dir];
                            int nCol = pollCell.col + dCol[dir];

                            // 5-2-1. 이미 번식이 된 위치면 번식하지 않는다.
                            if(visited[nRow][nCol]) continue;

                            visited[nRow][nCol] = true;
                            // 5-2-2. 번식한 줄기 세포의 배양 여부를 체크하고 임시로 큐에 저장한다.
                            queue.add(new Cell(nRow, nCol, pollCell.time, pollCell.time * 2));
                        }
                    }
                    // 5-3. 기존의 줄기 세포 중 죽지 않은 세포(남은생명력 != 0)를 임시로 큐에 저장한다.
                    if(pollCell.leftTime != 0) queue.add(pollCell);
                }
                // 5-4. 임시 큐에서 우선순위 큐로 모든 활성+비활성 세포를 옮긴다.
                while(!queue.isEmpty()) pq.add(queue.poll());
            }
            // 6. 우선순위 큐에는 활성+비활성 상태의 줄기 세포가 저장되므로 우선순위 큐의 size를 출력한다.
            sb.append(pq.size()).append('\n');
        }
        System.out.print(sb);
    }

    static class Cell {
        // 가로, 세로, 생명력, 남은 생명력
        int row, col, time, leftTime;

        public Cell(int row, int col, int time, int leftTime) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.leftTime = leftTime;
        }
    }
}
