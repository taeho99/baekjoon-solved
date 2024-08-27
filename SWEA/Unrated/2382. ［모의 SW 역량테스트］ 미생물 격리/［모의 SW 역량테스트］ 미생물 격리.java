import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  SWEA.2382 미생물격리
 *
 *  1. 구역의 크기와 격리 시간, 군집의 개수와 군집의 정보를 입력받는다.
 *      1-1. 각 셀은 여러 미생물이 합쳐지는 경우를 생각해 Queue로 구성한다.
 *  2. 총 격리 시간동안 미생물을 격리시킨다.
 *      2-1. 격리 시간동안 모든 셀에서 미생물 군집을 한 칸씩 이동시킨다.
 *          2-1-1. 만약 비어있는 셀이면 제외
 *          2-1-2. 이미 한 칸 이동한 미생물 군집이면 제외
 *          2-1-3. 다음 이동할 셀이 약품이 있는 셀이면 미생물 개수를 절반으로 줄이고, 방향 전환
 *          2-1-4. 이동한 셀에 미생물 군집을 할당
 *      2-2. 겹쳐져 있는 미생물 군집을 합치고 방문 해제 처리
 *          2-2-1. 만약 비어있는 셀이면 제외
 *          2-2-2. 해당 셀의 모든 미생물 개수를 더하기
 *          2-2-3. 현재 미생물 개수가 이때까지 최대 미생물 개수보다 크다면 방향을 현재 방향으로 갱신
 *          2-2-4. 방문 해제하고 미생물 합쳐진 미생물 군집 할당하기
 *  3. 남아있는 미생물 수를 모두 결과값에 더해준다.
 *      3-1. 만약 비어있는 셀이면 제외
 *  4. 남아있는 미생물 수를 출력한다.
 */
public class Solution {
    static Queue<Microbe>[][] map;
    static int size, totalTime, microbeCnt;
    static int[] dRow = {0, -1, 1, 0, 0};
    static int[] dCol = {0, 0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 구역의 크기와 격리 시간, 군집의 개수와 군집의 정보를 입력받는다.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            totalTime = Integer.parseInt(st.nextToken());
            microbeCnt = Integer.parseInt(st.nextToken());

            // 1-1. 각 셀은 여러 미생물이 합쳐지는 경우를 생각해 Queue로 구성한다.
            map = new LinkedList[size][size];
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    map[row][col] = new LinkedList<>();
                }
            }

            for(int idx=0; idx<microbeCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                map[row][col].add(new Microbe(row, col, cnt, dir, false));
            }

            // 2. 총 격리 시간동안 미생물을 격리시킨다.
            for(int time=1; time<=totalTime; time++) {
                // 2-1. 격리 시간동안 모든 셀에서 미생물 군집을 한 칸씩 이동시킨다.
                for(int row=0; row<size; row++) {
                    for(int col=0; col<size; col++) {
                        // 2-1-1. 만약 비어있는 셀이면 제외
                        if(map[row][col].isEmpty()) continue;
                        // 2-1-2. 이미 한 칸 이동한 미생물 군집이면 제외
                        if(map[row][col].peek().visited) continue;

                        Microbe now = map[row][col].poll();
                        int nRow = now.row + dRow[now.dir];
                        int nCol = now.col + dCol[now.dir];

                        // 2-1-3. 다음 이동할 셀이 약품이 있는 셀이면 미생물 개수를 절반으로 줄이고, 방향 전환
                        now.cnt = isMedicineCell(nRow, nCol) ? now.cnt / 2 : now.cnt;
                        now.dir = isMedicineCell(nRow, nCol) ? changeDirection(now.dir) : now.dir;
                        now.row = nRow;
                        now.col = nCol;
                        now.visited = true;

                        // 2-1-4. 이동한 셀에 미생물 군집을 할당
                        map[now.row][now.col].add(now);
                    }
                }

                // 2-2. 겹쳐져 있는 미생물 군집을 합치고 방문 해제 처리
                for(int row=0; row<size; row++) {
                    for(int col=0; col<size; col++) {
                        // 2-2-1. 만약 비어있는 셀이면 제외
                        if(map[row][col].isEmpty()) continue;

                        int sumCnt = 0;
                        int maxCnt = 0;
                        int dir = 0;

                        // 2-2-2. 해당 셀의 모든 미생물 개수를 더하기
                        while(!map[row][col].isEmpty()) {
                            Microbe poll = map[row][col].poll();
                            sumCnt += poll.cnt;

                            // 2-2-3. 현재 미생물 개수가 이때까지 최대 미생물 개수보다 크다면 방향을 현재 방향으로 갱신
                            if(poll.cnt > maxCnt) {
                                maxCnt = poll.cnt;
                                dir = poll.dir;
                            }
                        }

                        // 2-2-4. 방문 해제하고 미생물 합쳐진 미생물 군집 할당하기
                        map[row][col].add(new Microbe(row, col, sumCnt, dir, false));
                    }
                }
            }

            // 3. 남아있는 미생물 수를 모두 결과값에 더해준다.
            int resultSum = 0;
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    // 3-1. 만약 비어있는 셀이면 제외
                    if(map[row][col].isEmpty()) continue;
                    
                    resultSum += map[row][col].poll().cnt;
                }
            }
            // 4. 남아있는 미생물 수를 출력한다.
            sb.append(resultSum).append(' ').append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isMedicineCell(int row, int col) {
        return row == 0 || row == size-1 || col == 0 || col == size-1;
    }

    private static int changeDirection(int dir) {
        if(dir == 1 || dir == 3) return dir+1;
        return dir-1;
    }

    static class Microbe {
        int row, col, cnt, dir;
        boolean visited;

        public Microbe(int row, int col, int cnt, int dir, boolean visited) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.dir = dir;
            this.visited = visited;
        }
    }
}