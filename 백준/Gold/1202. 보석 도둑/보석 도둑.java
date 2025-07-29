import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int jewelCnt = Integer.parseInt(st.nextToken());
		int bagCnt = Integer.parseInt(st.nextToken());
		List<Jewel> jewels = new ArrayList<>();
		List<Integer> bags = new ArrayList<>();

		while(jewelCnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(weight, value));
		}

		while(bagCnt-- > 0) {
			bags.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(jewels);
		Collections.sort(bags);

		long result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for(int bagIdx=0, jewelIdx=0; bagIdx<bags.size(); bagIdx++) {
			while(jewelIdx < jewels.size() && bags.get(bagIdx) >= jewels.get(jewelIdx).weight) {
				pq.add(jewels.get(jewelIdx++).value);
			}
			if(!pq.isEmpty()) result += pq.poll();
		}
		System.out.println(result);
	}

	static class Jewel implements Comparable<Jewel> {
		int weight, value;

		public Jewel(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Jewel o) {
			if (this.weight == o.weight) {
				return Integer.compare(o.value, this.value);
			}
			return Integer.compare(this.weight, o.weight);
		}
	}
}
