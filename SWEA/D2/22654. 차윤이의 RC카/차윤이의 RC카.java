import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int size, cmdCnt, cmdLen, startRow, startCol;
    static String cmds;
    static char[][] map;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            size = Integer.parseInt(br.readLine());

            map = new char[size][size];
            for(int row=0; row<size; row++) {
                String tmp = br.readLine();
                for(int col=0; col<size; col++) {
                    map[row][col] = tmp.charAt(col);
                    if(map[row][col] == 'X') {
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            cmdCnt = Integer.parseInt(br.readLine());
            for(int idx=0; idx<cmdCnt; idx++) {
                st = new StringTokenizer(br.readLine());

                cmdLen = Integer.parseInt(st.nextToken());
                cmds = st.nextToken();

                sb.append(drive() ? "1" : "0").append(' ');
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean drive() {
        int row = startRow, col = startCol, dir = 0;
        for (char cmd : cmds.toCharArray()) {
            if(cmd == 'L') {
                dir = (dir + 3) % 4;
            } else if (cmd == 'R') {
                dir = (dir + 1) % 4;
            } else if (cmd == 'A') {
                int nRow = row + dRow[dir];
                int nCol = col + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || map[nRow][nCol] == 'T')
                   continue;

                row = nRow;
                col = nCol;
            }
        }

        return map[row][col] == 'Y';
    }
}