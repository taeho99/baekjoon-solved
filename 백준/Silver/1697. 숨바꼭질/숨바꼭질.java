import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        boolean[] visited = new boolean[100001];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(n, 0));
        visited[n] = true;

        while(!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.point;
            int day = poll.day;
            if (x == k) {
                System.out.print(poll.day);
                return;
            }
            if (x+1 >= 0 && x+1 <= 100000 && !visited[x+1]) {
                visited[x+1] = true;
                queue.add(new Pair(x+1, day+1));
            }
            if (x-1 >= 0 && x-1 <= 100000 && !visited[x-1]) {
                visited[x-1] = true;
                queue.add(new Pair(x-1, day+1));
            }
            if (x*2 >= 0 && x*2 <= 100000 && !visited[x*2]) {
                visited[x*2] = true;
                queue.add(new Pair(x*2, day+1));
            }
        }
    }
    static class Pair {
        int point;
        int day;

        public Pair(int point, int day) {
            this.point = point;
            this.day = day;
        }
    }
}
