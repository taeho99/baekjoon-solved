import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Room> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Room(start, end, end-start));
        }

        Collections.sort(list);

        List<Room> result = new ArrayList<>();
        result.add(list.get(0));
        for(int i=1; i<n; i++) {
            if(list.get(i).start >= result.get(result.size()-1).end) {
                result.add(list.get(i));
            }
        }

        System.out.println(result.size());
    }

    static class Room implements Comparable<Room>{
        int start, end, time;

        public Room(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Room o) {
            if(end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }
}
