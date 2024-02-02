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
        int m = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int count = 0;
        int left = 0;
        int right = arr.size() - 1;
        int sum = arr.get(left) + arr.get(right);
        while(left < right) {
            if (sum == m) {
                count++;
                left++;
                right--;
                sum = arr.get(left) + arr.get(right);
            } else if (sum < m) {
                left++;
                sum = arr.get(left) + arr.get(right);
            } else {
                right--;
                sum = arr.get(left) + arr.get(right);
            }
        }

        System.out.println(count);
    }
}
