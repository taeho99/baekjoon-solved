import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  SWEA.7733 치즈도둑
 *
 *  1. 치즈의 크기와 맛있는 정도를 입력받는다.
 *      1-1. 최솟값과 최댓값을 입력받아 요정이 minTaste~(maxTaste-1) 까지 갉아먹을 수 있다.
 *  2. X일 갉아먹었을 때마다 모든 지점에서 BFS 탐색을하며 덩어리를 찾는다.
 *      2-1. 이미 방문(덩어리 체크)했거나 이미 갉아먹은 치즈는 제외
 *      2-2. X일마다 최대 덩어리 개수를 갱신해준다.
 *  3. 최대 덩어리의 개수 result를 출력한다.
 */
public class Solution {
    static int[][] map;
    static int size, maxTaste, result;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 치즈의 크기와 맛있는 정도를 입력받는다.
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            maxTaste = 0;
            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    // 1-1. 최댓값을 입력받아 요정이 (maxTaste-1) 까지 갉아먹을 수 있다.
                    maxTaste = Math.max(maxTaste, map[row][col]);
                }
            }

            result = 0;
            // 2. X일 갉아먹었을 때마다 모든 지점에서 BFS 탐색을하며 덩어리를 찾는다.
            for(int taste=0; taste<maxTaste; taste++) {
                visited = new boolean[size][size];
                int cnt = 0;
                for(int row=0; row<size; row++) {
                    for(int col=0; col<size; col++) {
                        // 2-1. 이미 방문(덩어리 체크)했거나 이미 갉아먹은 치즈는 제외
                        if(visited[row][col] || map[row][col] <= taste) continue;
                        cnt++;
                        bfs(row, col, taste);
                    }
                }
                // 2-2. X일마다 최대 덩어리 개수를 갱신해준다.
                result = Math.max(result, cnt);
            }
            // 3. 최대 덩어리의 개수 result를 출력한다.
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    private static void bfs(int row, int col, int taste) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

                if(!visited[nRow][nCol] && map[nRow][nCol] > taste) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }
}
