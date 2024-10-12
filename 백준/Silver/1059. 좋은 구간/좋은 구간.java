import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<n; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(br.readLine());

        int left = 0, right = 1000;
        for(int idx=0; idx<n; idx++) {
            if(arr[idx] == target) {
                System.out.println("0");
                return;
            }
            if(arr[idx] < target) left = Math.max(left, arr[idx]);
            if(target < arr[idx]) right = Math.min(right, arr[idx]);
        }

        System.out.println((target-left)*(right-target)-1);
    }
}