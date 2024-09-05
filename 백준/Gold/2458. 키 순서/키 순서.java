import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA.5643 키순서
 * 
 * 	0. 각 학생 번호를 정점, 키 순서 관계는 간선으로 표현한다.
 * 	1. 정점의 수와 간선의 수를 입력받는다.
 * 	2. 인접 리스트를 만든다. 나보다 키가 큰 순(정방향)과 키가 작은 순(역방향) 탐색을 위해 인접 리스트를 2개 만든다.
 * 	3. 모든 정점에서 나보다 키 작은 애들 수와 키가 큰 애들 수를 구한다.
 * 		3-1. 현재 정점에서 bfs 탐색을 시작해 키 작은 수, 키 큰 수를 구한다.
 * 		3-2. 키 작은 수와 키 큰 수를 더한 값이 (총 정점 개수-1)개이면 결과값을 1 증가시킨다. (나를 제외한 모든 정점이 내 앞인지 뒤인지 알 수 있음)
 * 	4. 결과값 출력하기
 */
public class Main {
	static int T;
	static int vertexCnt, edgeCnt, result;
	static ArrayList<Integer>[] adj, adjReverse;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
			
        // 1. 정점의 수와 간선의 수를 입력받는다.
        st = new StringTokenizer(br.readLine().trim());
        vertexCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 2. 인접 리스트를 만든다. 나보다 키가 큰 순(정방향)과 키가 작은 순(역방향) 탐색을 위해 인접 리스트를 2개 만든다.
        adj = new ArrayList[vertexCnt];
        adjReverse = new ArrayList[vertexCnt];
        for(int idx=0; idx<vertexCnt; idx++) {
            adj[idx] = new ArrayList<>();
            adjReverse[idx] = new ArrayList<>();
        }

        for(int idx=0; idx<edgeCnt; idx++) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            adj[from].add(to);
            adjReverse[to].add(from);
        }

        // 3. 모든 정점에서 나보다 키 작은 애들 수와 키가 큰 애들 수를 구한다.
        for(int idx=0; idx<vertexCnt; idx++) {
            // 3-1. 현재 정점에서 bfs 탐색을 시작해 키 작은 수, 키 큰 수를 구한다.
            int inCnt = bfs(idx, adjReverse); // 나보다 키 작은 애들 수
            int outCnt = bfs(idx, adj); // 나보다 키 큰 애들 수

            // 3-2. 키 작은 수와 키 큰 수를 더한 값이 (총 정점 개수-1)개이면 결과값을 1 증가시킨다. 
            // (나를 제외한 모든 정점이 내 앞인지 뒤인지 알 수 있음)
            if(inCnt + outCnt == vertexCnt-1) result++;
        }

        // 4. 결과값 출력하기
        System.out.print(result);
	}

	private static int bfs(int startIdx, ArrayList<Integer>[] adj) {
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertexCnt];
		
		queue.add(startIdx);
		visited[startIdx] = true;
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for (int next : adj[poll]) {
				if(visited[next]) continue;
				visited[next] = true;
				queue.add(next);
				cnt++;
			}
		}
		
		return cnt;
	}
}