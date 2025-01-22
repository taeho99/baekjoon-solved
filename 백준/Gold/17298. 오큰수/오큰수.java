import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] seq = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<size; idx++) {
            seq[idx] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int idx=0; idx<size; idx++) {
            while(!stack.isEmpty() && seq[stack.peek()] < seq[idx]) {
                seq[stack.pop()] = seq[idx];
            }
            stack.push(idx);
        }

        while(!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        for(int idx=0; idx<size; idx++) {
            sb.append(seq[idx]).append(' ');
        }
        System.out.print(sb);
    }
}