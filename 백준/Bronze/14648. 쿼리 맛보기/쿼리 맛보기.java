import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                long sum = 0;
                for(int j=a; j<=b; j++) {
                    sum += arr[j];
                }
                System.out.println(sum);
                int tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                long sum1 = 0, sum2 = 0;
                for(int j=a-1; j<b; j++) {
                    sum1 += arr[j];
                }
                for(int j=c-1; j<d; j++) {
                    sum2 += arr[j];
                }
                System.out.println(sum1 - sum2);
            }
        }
    }
}
