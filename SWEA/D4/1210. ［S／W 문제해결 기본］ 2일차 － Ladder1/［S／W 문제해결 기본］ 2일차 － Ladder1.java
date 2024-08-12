import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1; tc<=10; tc++) {
            br.readLine();
            int[][] map = new int[100][100];
            int[] arrive = new int[2];
            for(int row=0; row<100; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<100; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    if(map[row][col] == 2) {
                        arrive[0] = row;
                        arrive[1] = col;
                    }
                }
            }

            int col = arrive[1];
            for(int row=arrive[0]; row >=0; row--) {
                boolean check = false;
                while(col - 1 >= 0 && map[row][col-1] == 1) {
                    col--;
                    check = true;
                }
                if(check) continue;
                while(col + 1 <= 99 && map[row][col+1] == 1) {
                    col++;
                }
            }
            sb.append('#').append(tc).append(' ').append(col).append('\n');
        }
        System.out.print(sb);
    }
}
