import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(true) {
            if (queue.size() != 1)
                queue.poll();
            if (queue.size() == 1) break;
            Integer tmp = queue.poll();
            queue.add(tmp);
        }
        System.out.println(queue.poll());
    }
}
