import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 높이가 주어진 N*N map이 주어진다.
 * 2. 딱 한 곳을 깎을 수 있으며 최대 깎을 수 있는 깊이 K가 주어진다.
 * 3. 가장 높은 봉우리의 높이를 저장한다.
 * 4. 가장 높은 봉우리에서 아무 곳도 깎지 않은 상태에서 등산로를 찾는다. (BFS)
 *      4-1. 1~K 까지 깎을 높이를 모두 확인한다.
 *          4-1-1. 시작 봉우리를 제외하고 모든 위치를 1, 2, ... , K만큼 깎아보고 등산로를 찾는다. (BFS)
 *          4-1-2. 깎은 깊이를 원상태로 되돌려준다.
 * 5. 현재까지 만든 등산로 길이를 저장해가며 BFS 탐색을 한다.
 *      5-1. 만들 수 있는 등산로 길이를 maxLength에 갱신해가며 최대 등산로 길이를 찾는다.
 * 6. 최대 등산로 길이를 출력한다.
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
            // 1. 높이가 주어진 N*N map이 주어진다.
            size = Integer.parseInt(st.nextToken());
            map = new int[size][size];
            // 2. 딱 한 곳을 깎을 수 있으며 최대 깎을 수 있는 깊이 K가 주어진다.
            K = Integer.parseInt(st.nextToken());

            maxHeight = 0;

            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    // 3. 가장 높은 봉우리의 높이를 저장한다.
                    maxHeight = Math.max(maxHeight, map[row][col]);
                }
            }

            maxLength = 0;
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    if(map[row][col] == maxHeight) {
                        startRow = row;
                        startCol = col;
                        // 4. 가장 높은 봉우리에서 아무 곳도 깎지 않은 상태에서 등산로를 찾는다. (BFS)
                        BFS();

                        // 4-1. 1~K 까지 깎을 높이를 모두 확인한다.
                        for(nowK=1; nowK<=K; nowK++) {
                            // 4-1-1. 시작 봉우리를 제외하고 모든 위치를 1, 2, ... , K만큼 깎아보고 등산로를 찾는다. (BFS)
                            for(int mineRow=0; mineRow<size; mineRow++) {
                                for(int mineCol=0; mineCol<size; mineCol++) {
                                    if(startRow == mineRow && startCol == mineCol) continue; // 시작 봉우리 제외
                                    map[mineRow][mineCol] -= nowK;
                                    BFS();
                                    // 4-1-2. 깎은 깊이를 원상태로 되돌려준다.
                                    map[mineRow][mineCol] += nowK;
                                }
                            }
                        }
                    }
                }
            }

            // 6. 최대 등산로 길이를 출력한다.
            sb.append(maxLength).append('\n');
        }
        System.out.print(sb);
    }

    // 5. 현재까지 만든 등산로 길이를 저장해가며 BFS 탐색을 한다.
    private static void BFS() {

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startRow, startCol, 1));

        while(!queue.isEmpty()) {
            Point poll = queue.poll();

            for(int idx=0; idx<4; idx++) {
                int nRow = poll.row + dRow[idx];
                int nCol = poll.col + dCol[idx];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

                if(map[nRow][nCol] < map[poll.row][poll.col]) {
                    // 5-1. 만들 수 있는 등산로 길이를 maxLength에 갱신해가며 최대 등산로 길이를 찾는다.
                    queue.add(new Point(nRow, nCol, poll.length + 1));
                    maxLength = Math.max(maxLength, poll.length + 1);
                }
            }
        }
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
