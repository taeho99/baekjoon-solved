import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ.15686 치킨 배달
 *
 * 1. 치킨 집 중 M개의 치킨집의 조합을 구한다.
 * 2. 모든 집에서 선택된 치킨 집과의 거리를 구한다.
 * 3. 최솟값을 갱신한다.
 */
public class Main {
    static int ELEMENT_COUNT, SELECT_COUNT, MAP_SIZE, minResult = Integer.MAX_VALUE;
    static Point[] selectStore;
    static ArrayList<Point> elementStore, homeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        MAP_SIZE = Integer.parseInt(st.nextToken());
        SELECT_COUNT = Integer.parseInt(st.nextToken());
        selectStore = new Point[SELECT_COUNT];
        elementStore = new ArrayList<>();
        homeList = new ArrayList<>();

        for(int row=0; row<MAP_SIZE; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<MAP_SIZE; col++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    homeList.add(new Point(row, col));
                } else if (tmp == 2) {
                    elementStore.add(new Point(row, col));
                }
            }
        }
        ELEMENT_COUNT = elementStore.size();

        combination(0, 0);

        System.out.print(minResult);
    }

    private static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == SELECT_COUNT) {
            int sum = 0;
            for (Point home : homeList) {
                int minDist = Integer.MAX_VALUE;
                for (Point store : selectStore) {
                    minDist = Math.min(minDist, home.getDistance(store));
                }
                sum += minDist;
            }
            minResult = Math.min(minResult, sum);
            return;
        }

        if(elementIdx == ELEMENT_COUNT) {
            return;
        }

        selectStore[selectIdx] = elementStore.get(elementIdx);
        combination(elementIdx + 1, selectIdx + 1);

        selectStore[selectIdx] = null;
        combination(elementIdx + 1, selectIdx);
    }

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }

        int getDistance(Point p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }
}
