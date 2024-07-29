import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N*N 크기에 색이 다른 사탕
 * 사탕의 색이 다른 인접한 두 칸 고름
 * 두 칸에 들어있는 사탕 교환
 * 같은 색이면서 가장 긴 사탕 행 OR 열 없앰
 */
public class Main {
    static char[][] map;
    static int size, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new char[size][size];

        for(int row=0; row<size; row++) {
            String input = br.readLine();
            for(int col=0; col<size; col++) {
                map[row][col] = input.charAt(col);
            }
        }

        for(int row=0; row<size; row++) {
            for(int col=0; col<size-1; col++) {
                swap(row, col, row, col+1);
                search();
                swap(row, col, row, col+1);
            }
        }

        for(int col=0; col<size; col++) {
            for(int row=0; row<size-1; row++) {
                swap(row, col, row+1, col);
                search();
                swap(row, col, row+1, col);
            }
        }
        System.out.println(result);
    }

    private static void search() {
        for(int row=0; row<size; row++) {
            int cnt = 1;
            for(int col=0; col<size-1; col++) {
                if(map[row][col] == map[row][col+1]) {
                    cnt++;
                    result = Math.max(result, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for(int col=0; col<size; col++) {
            int cnt = 1;
            for(int row=0; row<size-1; row++) {
                if(map[row][col] == map[row+1][col]) {
                    cnt++;
                    result = Math.max(result, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    private static void swap(int row1, int col1, int row2, int col2) {
        char tmp = map[row1][col1];
        map[row1][col1] = map[row2][col2];
        map[row2][col2] = tmp;
    }
}
