import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<k; i++) {
            int cmd = Integer.parseInt(st.nextToken()) - 1;
            int ny = y + dy[cmd];
            int nx = x + dx[cmd];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            y = ny; x = nx;
            Dice.move(cmd);
            if(map[y][x] == 0) {
                map[y][x] = Dice.getBottom();
            } else {
                Dice.setBottom(map[y][x]);
                map[y][x] = 0;
            }

            sb.append(Dice.getTop()).append('\n');
        }

        System.out.print(sb);

    }

    static class Dice {
        static int[] dice = new int[6];
        static int[][] direct = {
                {0,5,1,2,4,3},
                {0,2,3,5,4,1},
                {2,1,4,3,5,0},
                {5,1,0,3,2,4}
        };

        static void swap(int[] arr) {
            int[] tmp = new int[6];
            for(int i=0; i<6; i++) {
                tmp[arr[i]] = dice[i];
            }
            dice = tmp;
        }

        static void move(int d) {
            swap(direct[d]);
        }

        //윗면 idx: 2, 아랫면 idx: 5
        static int getTop() {
            return dice[2];
        }

        static int getBottom() {
            return dice[5];
        }

        static void setBottom(int x) {
            dice[5] = x;
        }
    }
}