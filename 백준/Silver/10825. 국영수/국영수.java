import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Score {
        String name;
        int s1, s2, s3;

        public Score(String name, int s1, int s2, int s3) {
            this.name = name;
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Score> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());
            list.add(new Score(name, s1, s2, s3));
        }
        list.stream().sorted((o1, o2) -> {
            if(o1.s1 == o2.s1) {
                if (o1.s2 == o2.s2) {
                    if (o1.s3 == o2.s3)
                        return o1.name.compareTo(o2.name);
                    return Integer.compare(o2.s3, o1.s3);
                }
                return Integer.compare(o1.s2, o2.s2);
            }
            return Integer.compare(o2.s1, o1.s1);
        }).forEach(System.out::println);
    }
}
