import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map = new int[9][9];
    static List<Point> puzzleList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int row=0; row<9; row++) {
            String tmp = br.readLine();
            for(int col=0; col<9; col++) {
                map[row][col] = tmp.charAt(col) - '0';
                if(map[row][col] == 0) puzzleList.add(new Point(row, col));
            }
        }

        sudoku(0);
    }

    private static void sudoku(int depth) {
        if(depth == puzzleList.size()) {
            printSudoku();
            System.exit(0);
        }

        Point now = puzzleList.get(depth);

        for(int num=1; num<=9; num++) {
            if(!isValid(now, num)) continue;
            map[now.row][now.col] = num;
            sudoku(depth+1);
            map[now.row][now.col] = 0;
        }
    }

    private static void printSudoku() {
        for(int row=0; row<9; row++) {
            for(int col=0; col<9; col++) {
                sb.append(map[row][col]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isValid(Point point, int num) {
        for(int idx=0; idx<9; idx++) {
            if(map[idx][point.col] == num || map[point.row][idx] == num) return false;
        }

        int startRow = point.row / 3 * 3;
        int startCol = point.col / 3 * 3;
        for(int row=startRow; row<startRow+3; row++) {
            for(int col=startCol; col<startCol+3; col++) {
                if(map[row][col] == num) return false;
            }
        }

        return true;
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}