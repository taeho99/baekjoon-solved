import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Pair> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);

            int result = 1;
            int min = list.get(0).b;

            for(int i=1; i<list.size(); i++) {
                if(list.get(i).b < min) {
                    result++;
                    min = list.get(i).b;
                }
            }
            System.out.println(result);
        }
    }
    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.a, o.a);
        }
    }
}
