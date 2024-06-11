import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        int decimal = 0;
        for(int i=0; i<m; i++) {
            decimal += Integer.parseInt(st.nextToken())*(int)Math.pow(a, m-i-1);
        }
        while(decimal != 0) {
            sb.insert(0, ' ').insert(0, decimal%b);
            decimal /= b;
        }
        System.out.println(sb);
    }
}
