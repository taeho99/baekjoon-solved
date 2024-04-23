import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int start=1001, end=0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            start = Math.min(start, l);
            end = Math.max(end, l);
        }

        Stack<Integer> stack = new Stack<>();
        int temp = arr[start];
        for(int i=start+1; i<=end; i++) {
            if(arr[i] < temp) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        stack.clear();

        temp = arr[end];
        for(int i=end-1; i>=start; i--) {
            if(arr[i] < temp) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        int sum = 0;
        for(int i=start; i<=end; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
