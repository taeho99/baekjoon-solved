import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    static int size, left, right;
    static int[][] map;
    static boolean[][] visited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());

        map = new int[size][size];
        for(int row=0; row<size; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<size; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[size][size];
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    if(visited[row][col]) continue;
                    int populationSum = bfs(row, col);
                    if(list.size() > 1) {
                        isMove = true;
                        int populationAvg = populationSum / list.size();
                        for (Node node : list) {
                            map[node.row][node.col] = populationAvg;
                        }
                    }
                }
            }
            if(!isMove) break;
            result++;
        }

        System.out.print(result);
    }

    private static int bfs(int startRow, int startCol) {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        list = new ArrayList<>();

        queue.add(new Node(startRow, startCol));
        list.add(new Node(startRow, startCol));
        visited[startRow][startCol] = true;
        int populationSum = map[startRow][startCol];

        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            for(int dir=0; dir<4; dir++) {
                int nRow = poll.row + dRow[dir];
                int nCol = poll.col + dCol[dir];
                if(nRow < 0 || nCol < 0 || nRow >= size || nCol >= size || visited[nRow][nCol]) continue;

                int diff = Math.abs(map[poll.row][poll.col] - map[nRow][nCol]);
                if(left <= diff && diff <= right) {
                    queue.add(new Node(nRow, nCol));
                    list.add(new Node(nRow, nCol));
                    populationSum += map[nRow][nCol];
                    visited[nRow][nCol] = true;
                }
            }
        }
        return populationSum;
    }

    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}