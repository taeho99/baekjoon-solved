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
        PriorityQueue<Node> pq = new PriorityQueue<>();

        visited[0][0] = true;
        pq.add(new Node(0, 0, 0));

        while(!pq.isEmpty()) {
            Node poll = pq.poll();

            if(poll.row == rowSize-1 && poll.col == colSize-1) {
                System.out.println(poll.cnt);
                return;
            }

            for(int dir=0; dir<4; dir++) {
                int nRow = poll.row + dRow[dir];
                int nCol = poll.col + dCol[dir];

                if(nRow < 0 || nCol < 0 || nRow >= rowSize || nCol >= colSize || visited[nRow][nCol])
                    continue;

                visited[nRow][nCol] = true;
                pq.add(new Node(nRow, nCol, poll.cnt + map[nRow][nCol]));
            }
        }

    }

    static class Node implements Comparable<Node> {
        int row, col, cnt;

        public Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}