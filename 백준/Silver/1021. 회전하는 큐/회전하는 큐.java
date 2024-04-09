import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            queue.addLast(i);
        }

        int result = 0, left = m-1, right = n-m;
        for(int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == queue.peekFirst()) {
                queue.pollFirst();
                continue;
            }

            int count = 0;
            for (int integer : queue) {
                count++;
                if(integer == num) break;
            }

            if (count <= queue.size()/2 + 1) { //왼쪽으로 뺄때
//                printQueue(queue);
//                System.out.println("왼: " + num);
                for(int j=1; j<count; j++) {
                    queue.addLast(queue.pollFirst());
                    result++;
                }
//                printQueue(queue);
//                System.out.println("rseult: " + result);
                queue.pollFirst();
            } else {
//                printQueue(queue);
//                System.out.println("오: " + num);
                for(int j=0; j<=queue.size()-count; j++) {
                    queue.addFirst(queue.pollLast());
                    result++;
                }
//                printQueue(queue);
//                System.out.println("rseult: " + result);
                queue.pollFirst();
            }
        }
        System.out.println(result);

    }

    private static void printQueue(ArrayDeque<Integer> queue) {
        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }
    }
}
