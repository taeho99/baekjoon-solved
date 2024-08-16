import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 높이가 주어진 N*N map이 주어진다.
 * 2. 가장 긴 등산로를 만들어야 한다.
 * 2-1. 가장 높은 봉우리에서 시작
 * 2-2. 반드시 높은 곳 -> 낮은 곳으로 가로 or 세로 방향 연결 (높이 같거나 대각선 X)
 * 2-3. 딱 한 곳을 정해서 최대 K 깊이만큼 높이를 깎을 수 있다.
 * 3. 만들 수 있는 가장 긴 등산로의 길이를 출력하시오.
 */
public class Solution {
    static int[][] map;
    static int size, K, maxHeight, startRow, startCol, nowK, maxLength;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[size][size];
            maxHeight = 0;

            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[row][col]);
                }
            }

            maxLength = 0;
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    if(map[row][col] == maxHeight) {
                        startRow = row;
                        startCol = col;
                        noMineBFS();

                        for(nowK=1; nowK<=K; nowK++) {
                            for(int mineRow=0; mineRow<size; mineRow++) {
                                for(int mineCol=0; mineCol<size; mineCol++) {
                                    if(startRow == mineRow && startCol == mineCol) continue;
//                                    System.out.println(row + " " + col + " " + nowK + " " + mineRow + " " + mineCol);
                                    map[mineRow][mineCol] -= nowK;
                                    noMineBFS();
                                    map[mineRow][mineCol] += nowK;
                                }
                            }
                        }
                    }
                }
            }

            sb.append(maxLength).append('\n');
        }
        System.out.print(sb);
    }

    private static void noMineBFS() {

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol, 1));

        while(!queue.isEmpty()) {
            Point poll = queue.poll();

            for(int idx=0; idx<4; idx++) {
                int nRow = poll.row + dRow[idx];
                int nCol = poll.col + dCol[idx];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

                if(map[nRow][nCol] < map[poll.row][poll.col]) {
                    queue.add(new Point(nRow, nCol, poll.length + 1));
                    maxLength = Math.max(maxLength, poll.length + 1);
                }
            }
        }
    }

    private static void bfs() {

    }

    static class Point {
        int row, col, length;

        public Point(int row, int col, int length) {
            this.row = row;
            this.col = col;
            this.length = length;
        }
    }
}
