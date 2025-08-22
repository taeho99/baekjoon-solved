import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int row=0; row<5; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<5; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] check = new boolean[5][5];
        for(int row=0; row<5; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<5; col++) {
                int num = Integer.parseInt(st.nextToken());
                checkBingo(num, check);
                if(isBingo(check)) {
                    System.out.println((row*5) + col + 1);
                    return;
                }
            }
        }
    }

    private static boolean isBingo(boolean[][] check) {
        int cnt = 0;
        for(int row=0; row<5; row++) {
            if(check[row][0] && check[row][1] && check[row][2] && check[row][3] && check[row][4]) {
                cnt++;
            }
        }

        for(int col=0; col<5; col++) {
            if(check[0][col] && check[1][col] && check[2][col] && check[3][col] && check[4][col]) {
                cnt++;
            }
        }

        if(check[0][0] && check[1][1] && check[2][2] && check[3][3] && check[4][4]) cnt++;
        if(check[0][4] && check[1][3] && check[2][2] && check[3][1] && check[4][0]) cnt++;
        return cnt >= 3;
    }

    private static void checkBingo(int num, boolean[][] check) {
        for(int row=0; row<5; row++) {
            for(int col=0; col<5; col++) {
                if(map[row][col] == num) {
                    check[row][col] = true;
                    return;
                }
            }
        }
    }
}
