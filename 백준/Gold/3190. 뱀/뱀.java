import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n, k, l;
    static int[][] map;
    static ArrayList<int[]> snake = new ArrayList<>();
    static HashMap<Integer, String> direct = new HashMap<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            map[y][x] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for(int i=0; i<l; i++) {
            st = new StringTokenizer(br.readLine());
            direct.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int time = 0, dir = 0;
        int curY = 0, curX = 0;
        snake.add(new int[] {curY, curX});
        while(true) {
            time++;
            int ny = curY + dy[dir];
            int nx = curX + dx[dir];

            if(isFinish(ny, nx)) {
                break;
            }

            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                snake.add(new int[] {ny, nx});
            } else {
                snake.add(new int[] {ny, nx});
                snake.remove(0);
            }

            curY = ny;
            curX = nx;

            if(direct.containsKey(time)) {
                if(direct.get(time).equals("D"))
                    dir = (dir + 1) % 4;
                else
                    dir = (dir + 3) % 4;
            }
        }
        System.out.println(time);
    }

    private static boolean isFinish(int y, int x) {
        if(y < 0 || y >= n || x < 0 || x >= n) return true;
        for (int[] s : snake) {
            if(s[0] == y && s[1] == x) return true;
        }
        return false;
    }
}
