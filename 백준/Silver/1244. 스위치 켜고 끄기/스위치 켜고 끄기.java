import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for(int j=num; j<=n; j+=num) {
                    arr[j] = !arr[j];
                }
            } else {
                arr[num] = !arr[num];
                int left = num-1, right = num+1;
                while(left > 0 && right <= n) {
                    if(arr[left] != arr[right]) break;
                    arr[left] = !arr[left--];
                    arr[right] = !arr[right++];
                }
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.print((arr[i] ? 1 : 0) + " ");
            if(i%20 == 0) System.out.println();
        }
    }
}
