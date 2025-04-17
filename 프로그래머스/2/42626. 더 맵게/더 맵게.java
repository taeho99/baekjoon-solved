import java.util.PriorityQueue;

public class Solution {

	public int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : scoville) {
			pq.add(i);
		}

		int count = 0;
		while(pq.size() >= 2) {
			if (pq.peek() >= K) {
				return count;
			}

			count++;
			int one = pq.poll();
			int two = pq.poll();
			pq.add(one + two*2);
		}
        if (pq.peek() >= K) return count;
        
		return -1;
	}
}
