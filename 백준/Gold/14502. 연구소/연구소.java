import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rowSize, colSize, ELEMENT_COUNT, SELECT_COUNT, maxSafeArea;
    static ArrayList<Point> virusList, safeAreaList;
    static Point[] selectSafeAreaList;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        ELEMENT_COUNT = 0;
        SELECT_COUNT = 3;

        virusList = new ArrayList<>();
        safeAreaList = new ArrayList<>();
        selectSafeAreaList = new Point[SELECT_COUNT];
        map = new int[rowSize][colSize];

        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if(map[row][col] == 0) {
                    ELEMENT_COUNT++;
                    safeAreaList.add(new Point(row, col));
                } else if (map[row][col] == 2) {
                    virusList.add(new Point(row, col));
                }
            }
        }

        combination(0, 0);
        System.out.println(maxSafeArea);
    }

    private static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == SELECT_COUNT) {
//            System.out.println(Arrays.toString(selectSafeAreaList));
            for (Point safeArea : selectSafeAreaList)
                map[safeArea.row][safeArea.col] = 1;
            maxSafeArea = Math.max(maxSafeArea, ELEMENT_COUNT - 3 - bfs());
            for (Point safeArea : selectSafeAreaList)
                map[safeArea.row][safeArea.col] = 0;
            return;
        }
        if(elementIdx == ELEMENT_COUNT) {
            return;
        }

        selectSafeAreaList[selectIdx] = safeAreaList.get(elementIdx);
        combination(elementIdx + 1, selectIdx + 1);

        selectSafeAreaList[selectIdx] = null;
        combination(elementIdx + 1, selectIdx);
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];
        int virusCnt = 0;
        for (Point virus : virusList) {
            queue.add(virus);
            visited[virus.row][virus.col] = true;
        }

        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            virusCnt++;

            for(int dir=0; dir<4; dir++) {
                int nextRow = poll.row + dRow[dir];
                int nextCol = poll.col + dCol[dir];

                if(nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize) continue;

                if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
                    queue.add(new Point(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return virusCnt - virusList.size();
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
