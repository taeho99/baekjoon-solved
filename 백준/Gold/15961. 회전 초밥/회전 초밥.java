import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] visit = new int[d+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        for(int i=0; i<k; i++) {
            if(visit[arr[i]] == 0) total++;
            visit[arr[i]]++;
        }
        int max = total;
        for(int i=1; i<n; i++) {
            if(visit[c] == 0)
                max = Math.max(max, total + 1);
            else
                max = Math.max(max, total);
            visit[arr[i - 1]]--;
            if(visit[arr[i-1]] == 0) total--;
            if(visit[arr[(i+k-1)%n]] == 0) total++;
            visit[arr[(i+k-1)%n]]++;
        }
        if(visit[c] == 0)
            max = Math.max(max, total + 1);
        else
            max = Math.max(max, total);
        System.out.println(max);
    }
}
