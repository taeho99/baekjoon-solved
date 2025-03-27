import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for (Point point : list) {
            sb.append(point.x).append(' ').append(point.y).append('\n');
        }
        System.out.print(sb);
    }

    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (this.y == p.y) return this.x - p.x;
            return this.y - p.y;
        }
    }
}
