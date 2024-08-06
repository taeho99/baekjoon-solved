import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int size;
    static int[][] map, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            sb.append('#').append(t).append('\n');

            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            map = new int[size][size];
            answer = new int[size][size];
            String cmd = st.nextToken();

            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            switch(cmd) {
                case "up":
                    up();
                    break;
                case "down":
                    down();
                    break;
                case "left":
                    left();
                    break;
                case "right":
                    right();
                    break;
            }

            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    sb.append(answer[row][col]).append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void up() {
        for(int col=0; col<size; col++) {
            for(int row=0; row<size-1; row++) {
                if(map[row][col] == 0) continue;
                int nextRow = row+1;

                while(map[nextRow][col] == 0) {
                    if(nextRow == size-1) break;
                    nextRow++;
                }

                if(map[row][col] == map[nextRow][col]) {
                    map[row][col] += map[nextRow][col];
                    map[nextRow][col] = 0;
                    row = nextRow;
                }
            }
        }

        for(int col=0; col<size; col++) {
            int nextRow = 0;
            for(int row=0; row<size; row++) {
                if(map[row][col] != 0) {
                    answer[nextRow++][col] = map[row][col];
                }
            }
        }
    }

    private static void down() {
        for(int col=0; col<size; col++) {
            for(int row=size-1; row>0; row--) {
                if(map[row][col] == 0) continue;
                int nextRow = row-1;

                while(map[nextRow][col] == 0) {
                    if(nextRow == 0) break;
                    nextRow--;
                }

                if(map[row][col] == map[nextRow][col]) {
                    map[row][col] += map[nextRow][col];
                    map[nextRow][col] = 0;
                    row = nextRow;
                }
            }
        }

        for(int col=0; col<size; col++) {
            int nextRow = size-1;
            for(int row=size-1; row>=0; row--) {
                if(map[row][col] != 0) {
                    answer[nextRow--][col] = map[row][col];
                }
            }
        }
    }

    private static void left() {
        for(int row=0; row<size; row++) {
            for(int col=0; col<size-1; col++) {
                if(map[row][col] == 0) continue;
                int nextCol = col+1;

                while(map[row][nextCol] == 0) {
                    if(nextCol == size-1) break;
                    nextCol++;
                }

                if(map[row][col] == map[row][nextCol]) {
                    map[row][col] += map[row][nextCol];
                    map[row][nextCol] = 0;
                    col = nextCol;
                }
            }
        }

        for(int row=0; row<size; row++) {
            int nextCol = 0;
            for(int col=0; col<size; col++) {
                if(map[row][col] != 0) {
                    answer[row][nextCol++] = map[row][col];
                }
            }
        }
    }

    private static void right() {
        for(int row=0; row<size; row++) {
            for(int col=size-1; col>0; col--) {
                if(map[row][col] == 0) continue;
                int nextCol = col-1;

                while(map[row][nextCol] == 0) {
                    if(nextCol == 0) break;
                    nextCol--;
                }

                if(map[row][col] == map[row][nextCol]) {
                    map[row][col] += map[row][nextCol];
                    map[row][nextCol] = 0;
                    col = nextCol;
                }
            }
        }

        for(int row=0; row<size; row++) {
            int nextCol = size-1;
            for(int col=size-1; col>=0; col--) {
                if(map[row][col] != 0) {
                    answer[row][nextCol--] = map[row][col];
                }
            }
        }
    }
}
