import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    static int size, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        map = new char[size][size];

        for(int row=0; row<size; row++) {
            map[row] = br.readLine().toCharArray();
        }

        for(int row=0; row<size; row++) {
            for(int col=0; col<size-1; col++) {
                swap(row, col, row, col+1);
                search();
                swap(row, col, row, col+1);
            }
        }

        for(int row=0; row<size-1; row++) {
            for(int col=0; col<size; col++) {
                swap(row, col, row+1, col);
                search();
                swap(row, col, row+1, col);
            }
        }

        System.out.print(result);
    }

    private static void search() {
        for(int row=0; row<size; row++) {
            char prev = map[row][0];
            int cnt = 1;
            for(int col=1; col<size; col++) {
                if (prev == map[row][col]) {
                    cnt++;
                    result = Math.max(cnt, result);
                } else {
                    cnt = 1;
                }
                prev = map[row][col];
            }
        }

        for(int col=0; col<size; col++) {
            char prev = map[0][col];
            int cnt = 1;
            for(int row=1; row<size; row++) {
                if (prev == map[row][col]) {
                    cnt++;
                    result = Math.max(cnt, result);
                } else {
                    cnt = 1;
                }
                prev = map[row][col];
            }
        }
    }

    private static void swap(int row1, int col1, int row2, int col2) {
        char temp = map[row1][col1];
        map[row1][col1] = map[row2][col2];
        map[row2][col2] = temp;
    }
}