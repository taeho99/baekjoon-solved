import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int rowSize, colSize;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        for(int row=0; row<rowSize; row++) {
            String tmp = br.readLine();
            for(int col=0; col<colSize; col++) {
                map[row][col] = tmp.charAt(col) - '0';
            }
        }

        boolean[][] visited = new boolean[rowSize][colSize];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        visited[0][0] = true;
        pq.add(new int[] {0, 0, 0});

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();

            if(poll[0] == rowSize-1 && poll[1] == colSize-1) {
                System.out.println(poll[2]);
                return;
            }

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow < 0 || nCol < 0 || nRow >= rowSize || nCol >= colSize || visited[nRow][nCol])
                    continue;

                if(map[nRow][nCol] == 0) {
                    visited[nRow][nCol] = true;
                    pq.add(new int[]{nRow, nCol, poll[2]});
                } else {
                    visited[nRow][nCol] = true;
                    pq.add(new int[]{nRow, nCol, poll[2]+1});
                }
            }
        }

    }
}