import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        while(N-- > 0) {
            arr[N] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.print(arr[K-1]);
    }
}