import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int size;
    static int[][] miro, best;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int row, col, weight;

        public Node(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        miro = new int[size][size];
        best = new int[size][size];

        for(int row=0; row<size; row++) {
            String tmp = br.readLine();
            for(int col=0; col<size; col++) {
                miro[row][col] = tmp.charAt(col) == '0' ? 1 : 0;
            }
            Arrays.fill(best[row], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        best[0][0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(best[now.row][now.col] < now.weight) continue;

            for(int dir=0; dir<4; dir++) {
                int nRow = now.row + dRow[dir];
                int nCol = now.col + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
                if(best[nRow][nCol] > best[now.row][now.col] + miro[nRow][nCol]) {
                    best[nRow][nCol] = best[now.row][now.col] + miro[nRow][nCol];
                    pq.add(new Node(nRow, nCol, best[nRow][nCol]));
                }
            }
        }

        System.out.print(best[size-1][size-1]);
    }
}