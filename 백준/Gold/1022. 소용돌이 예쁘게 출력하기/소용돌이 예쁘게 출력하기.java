import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r1, c1, r2, c2;
    static int[][] map;
    static int[] dRow = {0, -1, 0, 1};
    static int[] dCol = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        map = new int[r2-r1+1][c2-c1+1];

        int maxValue = fill();

        int maxValueLen = String.valueOf(maxValue).length();
        for(int row=0; row<=(r2-r1); row++) {
            for(int col=0; col<=(c2-c1); col++) {
                sb.append(String.format("%"+ maxValueLen + "d ", map[row][col]));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static int fill() {
        int row = 0, col = 0, num = 1, dist = 1, max = 0;
        while(true) {
            for(int dir=0; dir<4; dir++) {
                for (int idx = 0; idx < dist; idx++) {
                    if(r1 <= row && row <= r2 && c1 <= col && col <= c2) {
                        map[row-r1][col-c1] = num;
                        max = Math.max(max, num);
                    }
                    row = row + dRow[dir];
                    col = col + dCol[dir];
                    num++;

                    if(map[0][0] != 0 && map[r2-r1][0] != 0 && map[0][c2-c1] != 0 && map[r2-r1][c2-c1] != 0)
                        return max;
                }
                if(dir == 1 || dir == 3) dist++;
            }
        }
    }
}