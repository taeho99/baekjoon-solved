import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while(size -- > 0) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		if(pq.size() == 1) {
			System.out.println(0);
			return;
		}

		int ans = 0;
		while(pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();
			ans += a+b;
			pq.add(a+b);
		}
		System.out.println(ans);
	}
}
