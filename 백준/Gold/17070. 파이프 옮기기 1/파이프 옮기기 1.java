import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int size, result;
    static int[][] map;
    static int[] dRow = {0, 1, 1}; // 가로, 세로, 대각선
    static int[] dCol = {1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        for(int row=0; row<size; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<size; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        if(map[size-1][size-1] == 1) {
            System.out.print(0);
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {0, 1, 0});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            if(poll[0] == size-1 && poll[1] == size-1) {
                result++;
                continue;
            }

            for(int dir=0; dir<3; dir++) {
                if(poll[2] == 0 && dir == 1) continue;
                if(poll[2] == 1 && dir == 0) continue;

                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow >= size || nCol >= size || map[nRow][nCol] == 1) continue;
                if(dir == 2 && map[poll[0]][nCol] == 1 || map[nRow][poll[1]] == 1) continue; //대각선인 경우

                queue.add(new int[] {nRow, nCol, dir});
            }
        }

        System.out.print(result);
    }
}