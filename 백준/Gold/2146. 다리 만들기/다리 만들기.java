import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int size, result = Integer.MAX_VALUE;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int[][] map;
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

        setIsland();

        findOtherIsland();

        System.out.print(result);
    }

    private static void findOtherIsland() {
        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                if(map[row][col] != 0) {
                    bfs(row, col);
                }
            }
        }
    }

    private static void bfs(int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[size][size];

        queue.add(new int[] {startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            if(map[startRow][startCol] != map[poll[0]][poll[1]] && map[poll[0]][poll[1]] != 0) {
                result = Math.min(result, poll[2]-1);
                return;
            }

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || visited[nRow][nCol]) continue;

                queue.add(new int[] {nRow, nCol, poll[2] + 1});
                visited[nRow][nCol] = true;
            }
        }
    }

    private static void setIsland() {
        boolean[][] visited = new boolean[size][size];
        int islandNumber = 1;

        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                if(map[row][col] != 0 && !visited[row][col]) {
                    Queue<int[]> queue = new ArrayDeque<>();

                    queue.add(new int[] {row, col});
                    visited[row][col] = true;
                    map[row][col] = islandNumber;

                    while(!queue.isEmpty()) {
                        int[] poll = queue.poll();

                        for(int dir=0; dir<4; dir++) {
                            int nRow = poll[0] + dRow[dir];
                            int nCol = poll[1] + dCol[dir];

                            if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || visited[nRow][nCol] || map[nRow][nCol] == 0) continue;

                            queue.add(new int[] {nRow, nCol});
                            visited[nRow][nCol] = true;
                            map[nRow][nCol] = islandNumber;
                        }
                    }
                    islandNumber++;
                }
            }
        }
    }
}