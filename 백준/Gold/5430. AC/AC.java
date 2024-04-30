import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String cmd = br.readLine().replace("RR", "");
            int n = Integer.parseInt(br.readLine());
            String p = br.readLine();
            StringTokenizer st = new StringTokenizer(p.substring(1, p.length()-1), ",");
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for(int i=0; i<n; i++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean isRight = false;
            boolean error = false;
            for (char c : cmd.toCharArray()) {
                if(queue.isEmpty() && c == 'D') {
                    error = true;
                    break;
                }
                if(c == 'R') {
                    isRight = !isRight;
                } else {
                    if(isRight)
                        queue.pollLast();
                    else
                        queue.pollFirst();
                }
            }

            if(error) {
                sb.append("error\n");
            } else if (queue.isEmpty()) {
                sb.append("[]\n");
            } else {
                sb.append('[');
                if(isRight) {
                    while(!queue.isEmpty()) {
                        sb.append(queue.pollLast()).append(',');
                    }
                } else {
                    while(!queue.isEmpty()) {
                        sb.append(queue.pollFirst()).append(',');
                    }
                }
                sb.deleteCharAt(sb.length()-1).append(']').append('\n');
            }
        }
        System.out.print(sb);
    }
}
