import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author 임태호
 *
 * 1. 이중 우선순위 큐
 * 2. 'I n' : n을 Q에 삽입
 * 3-1. 'D 1' : 최댓값 삭제
 * 3-2. 'D -1' : 최솟값 삭제
 * 4. Q가 비어있으면 D 연산 무시
 * 5. 최댓값(최솟값)이 둘 이상이면 하나만 삭제
 */
public class Main {
	static PriorityQueue<Integer> maxQ;
	static PriorityQueue<Integer> minQ;
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			maxQ = new PriorityQueue<>(Collections.reverseOrder());
			minQ = new PriorityQueue<>();
			map = new HashMap<>();
			
			while(k-- > 0) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				
				if(cmd == 'I') {
					maxQ.add(n);
					minQ.add(n);
					map.put(n, map.getOrDefault(n, 0) + 1);
				} else {
					if(map.size() == 0) continue;
					delete(n);
				}
			}
			
			if(map.size() == 0) {
				System.out.println("EMPTY");
			} else {
				int max = delete(1);
				if(map.size() == 0) {
					System.out.println(max + " " + max);
				} else {
					System.out.println(max + " " + delete(-1));
				}
			}
		}
	}

	static int delete(int n) {
		PriorityQueue<Integer> pq = (n == 1 ? maxQ : minQ);
		int result = 0;
		while(true) {
			result = pq.poll();
			int get = map.getOrDefault(result, 0);
			if(get > 1) {
				map.put(result, map.get(result) - 1);
				break;
			} else if(get == 1) {
				map.remove(result);
				break;
			}
		}
		return result;
	}
}
