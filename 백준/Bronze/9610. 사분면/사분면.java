import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] result = new int[5];
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x == 0 || y == 0) {
                result[4]++;
            } else if (x > 0 && y > 0) {
                result[0]++;
            } else if (x < 0 && y > 0) {
                result[1]++;
            } else if (x < 0 && y < 0) {
                result[2]++;
            } else {
                result[3]++;
            }
        }
        String[] str = {"Q1: ", "Q2: ", "Q3: ", "Q4: ", "AXIS: "};
        for(int idx=0; idx<5; idx++) {
            System.out.println(str[idx] + result[idx]);
        }
    }
}
