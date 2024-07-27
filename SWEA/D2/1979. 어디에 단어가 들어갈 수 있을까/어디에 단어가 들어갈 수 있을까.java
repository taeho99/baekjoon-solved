import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int size, length;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());

            map = new int[size][size];
            for(int row = 0; row < size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            visited = new boolean[size][size];
            for(int row = 0; row < size; row++) {
                for(int col = 0; col < size; col++) {
                    if(!visited[row][col] && map[row][col] == 1) {
                        if(bfs(row, col, false) == length) {
                            result++;
                        }
                    }
                }
            }

            visited = new boolean[size][size];
            for(int row = 0; row < size; row++) {
                for(int col = 0; col < size; col++) {
                    if(!visited[row][col] && map[row][col] == 1) {
                        if(bfs(row, col, true) == length) {
                            result++;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    private static int bfs(int y, int x, boolean type) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y, x});
        visited[y][x] = true;

        int count = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;

            int ny = poll[0], nx = poll[1];
            if(!type) { //가로
                nx++;
            } else {
                ny++;
            }
            if(nx >= size || ny >= size) break;
            if(map[ny][nx] == 1 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
            }
        }
        return count;
    }
}
