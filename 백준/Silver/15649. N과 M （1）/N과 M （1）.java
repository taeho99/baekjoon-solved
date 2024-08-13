import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.15649 N과 M (1)
 *
 * 1. N과 M이 주어졌을 때, 1~N까지 자연수 중 중복 없이 M개를 고른 수열을 출력하라.
 * 2. elementList에 1~N까지 자연수를 담는다.
 * 3. 기저 조건은 selectIdx 즉, 선택된 원소가 SELECT_COUNT에 도달하면 종료한다.
 * 4-1. 중복 제거를 위해 이미 방문한 원소는 탐색하지 않는다.
 * 4-2. 원소를 selectList에 담고 방문 처리를 한다.
 * 4-3. 원소를 선택했으므로 다음 원소를 담으러 떠난다.
 * 4-4. 방문 처리를 해제한다.
 */
public class Main {
	static int ELEMENT_COUNT, SELECT_COUNT;
	static int[] elementList, selectList;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 및 변수 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		ELEMENT_COUNT = Integer.parseInt(st.nextToken());
		SELECT_COUNT = Integer.parseInt(st.nextToken());
		elementList = new int[ELEMENT_COUNT];
		selectList = new int[SELECT_COUNT];
		visited = new boolean[ELEMENT_COUNT];
		
		// 2. elementList에 1~N까지 자연수를 담는다.
		for(int elementIdx = 1; elementIdx <= ELEMENT_COUNT; elementIdx++) {
			elementList[elementIdx-1] = elementIdx;
		}
		
		permutation(0);
		System.out.print(sb);
	}

	public static void permutation(int selectIdx) {
		// 3. 기저 조건은 selectIdx 즉, 선택된 원소가 SELECT_COUNT에 도달하면 종료한다.
		if(selectIdx == SELECT_COUNT) {
			for(int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int elementIdx = 0; elementIdx < ELEMENT_COUNT; elementIdx++) {
			// 4-1. 중복 제거를 위해 이미 방문한 원소는 탐색하지 않는다.
			if(visited[elementIdx]) continue;
			
			// 4-2. 원소를 selectList에 담고 방문 처리를 한다.
			visited[elementIdx] = true;
			selectList[selectIdx] = elementList[elementIdx];
			// 4-3. 원소를 선택했으므로 다음 원소를 담으러 떠난다.
			permutation(selectIdx + 1);
			// 4-4. 방문 처리를 해제한다.
			visited[elementIdx] = false;
		}
	}	

}
