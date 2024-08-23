import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *	SWEA.5644 무선충전 
 *	
 *	1. 사용자의 이동 경로와 사용자가 속해있는 BC를 입력받는다.
 *		1-1. 첫 사용자의 위치를 먼저 넣어주고 그 다음 위치는 이동경로에 따라 계산한다.
 *		1-2. BC는 사용자의 우선순위 큐에 입력받는다. (성능이 높은 것부터 꺼내려고)
 *	2. 매 초마다 A와 B가 속한 BC를 알아본다. 우선순위 큐에서 성능이 높은 것부터 꺼내서 알아본다.
 *		2-0. (A가 갖고있는 BC는 A_BC, B가 갖고 있는 BC는 B_BC라 칭함)
 *		2-1. A_BC와 B_BC 모두 없으면 continue
 *		2-2. A_BC는 있고 B_BC는 없으면 -> A_BC의 성능 더하기
 *		2-3. B_BC는 있고 A_BC는 없으면 -> B_BC의 성능 더하기
 *		2-4. A_AC도 있고 B_BC도 있으면서 둘이 다른 BC이면 -> A_AC의 성능과 B_BC의 성능 둘 다 더하기
 *		2-5. A_AC와 B_BC가 같은 BC라면?
 *			2-5-1. A와 B 둘 다 BC가 하나면 -> 성능이 균등하게 분배되므로 A_BC의 성능 하나만 더하기
 *			2-5-2. A는 BC가 2개이상, B는 BC가 1개만 있으면 -> 두번째 A_BC 더하고 첫번째 B_BC 더하기
 *			2-5-3. A는 BC가 1개, B는 BC가 2개 이상 있으면 -> 첫번째 A_BC 더하고 두번째 B_BC 더하기
 *			2-5-4. A와 B 둘 다 BC가 2개 이상이면 -> 처음으로 꺼낸 BC 더하고 두번째 BC 중 더 큰 BC 더하기
 *	3. 성능의 최대 합(result)을 출력한다.
 */
public class Solution {
	static User[] pathA, pathB;
	static BC[] bcList;
	static int totalTime, bcCnt, result;
	static int[] dRow = {0, -1, 0, 1, 0};
	static int[] dCol = {0, 0, 1, 0, -1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			totalTime = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			result = 0;
			
			// 1. 사용자의 이동 경로와 사용자가 속해있는 BC를 입력받는다.
			st = new StringTokenizer(br.readLine());
			pathA = new User[totalTime+1];
			// 1-1. 첫 사용자의 위치를 먼저 넣어주고 그 다음 위치는 이동경로에 따라 계산한다.
			pathA[0] = new User(0, 0);
			for(int time=1; time<=totalTime; time++) {
				int dir = Integer.parseInt(st.nextToken());
				int nextRow = pathA[time-1].row + dRow[dir];
				int nextCol = pathA[time-1].col + dCol[dir];
				pathA[time] = new User(nextRow, nextCol);
			}

			// 1. 사용자의 이동 경로와 사용자가 속해있는 BC를 입력받는다.
			st = new StringTokenizer(br.readLine());
			pathB = new User[totalTime+1];
			// 1-1. 첫 사용자의 위치를 먼저 넣어주고 그 다음 위치는 이동경로에 따라 계산한다.
			pathB[0] = new User(9, 9);
			for(int time=1; time<=totalTime; time++) {
				int dir = Integer.parseInt(st.nextToken());
				int nextRow = pathB[time-1].row + dRow[dir];
				int nextCol = pathB[time-1].col + dCol[dir];
				pathB[time] = new User(nextRow, nextCol);
			}
			
			bcList = new BC[bcCnt];
			for(int bcIdx=0; bcIdx<bcCnt; bcIdx++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken()) - 1;
				int row = Integer.parseInt(st.nextToken()) - 1;
				int range = Integer.parseInt(st.nextToken());
				int performance = Integer.parseInt(st.nextToken());
				
				BC bc = new BC(row, col, range, performance);

				// 1-2. BC는 사용자의 우선순위 큐에 입력받는다. (성능이 높은 것부터 꺼내려고)
				for (User userA : pathA)
					if(userA.isWithinBC(bc)) userA.pq.add(bc);
				for (User userB : pathB)
					if(userB.isWithinBC(bc)) userB.pq.add(bc);
			}
			
			for(int time=0; time<=totalTime; time++) {
				// 2. 매 초마다 A와 B가 속한 BC를 알아본다. 우선순위 큐에서 성능이 높은 것부터 꺼내서 알아본다.
				// 2-0. (A가 갖고있는 BC는 A_BC, B가 갖고 있는 BC는 B_BC라 칭함)
				BC userA_BC = pathA[time].pq.poll();
				BC userB_BC = pathB[time].pq.poll();
				
				// 2-1. A_BC와 B_BC 모두 없으면 continue
				if(userA_BC == null && userB_BC == null) continue;
				
				// 2-2. A_BC는 있고 B_BC는 없으면 -> A_BC의 성능 더하기
				if(userA_BC != null && userB_BC == null) {
					result += userA_BC.performance;
				} 
				// 2-3. B_BC는 있고 A_BC는 없으면 -> B_BC의 성능 더하기
				else if(userA_BC == null && userB_BC != null) {
					result += userB_BC.performance;
				} 
				// 2-4. A_AC도 있고 B_BC도 있으면서 둘이 다른 BC이면 -> A_AC의 성능과 B_BC의 성능 둘 다 더하기
				else if(userA_BC.row != userB_BC.row || userA_BC.col != userB_BC.col) {
					result += userA_BC.performance;
					result += userB_BC.performance;
				} 
				// 2-5. A_AC와 B_BC가 같은 BC라면?
				else {
					// 2-5-1. A와 B 둘 다 BC가 하나면 -> 성능이 균등하게 분배되므로 A_BC의 성능 하나만 더하기
					if(pathA[time].pq.isEmpty() && pathB[time].pq.isEmpty()) {
						result += userA_BC.performance;
					} 
					// 2-5-2. A는 BC가 2개이상, B는 BC가 1개만 있으면 -> 두번째 A_BC 더하고 첫번째 B_BC 더하기
					else if(!pathA[time].pq.isEmpty() && pathB[time].pq.isEmpty()) {
						result += pathA[time].pq.poll().performance;
						result += userB_BC.performance;
					} 
					// 2-5-3. A는 BC가 1개, B는 BC가 2개 이상 있으면 -> 첫번째 A_BC 더하고 두번째 B_BC 더하기
					else if(pathA[time].pq.isEmpty() && !pathB[time].pq.isEmpty()) {
						result += userA_BC.performance;
						result += pathB[time].pq.poll().performance;
					} 
					// 2-5-4. A와 B 둘 다 BC가 2개 이상이면 -> 처음으로 꺼낸 BC 더하고 두번째 BC 중 더 큰 BC 더하기
					else {
						result += userA_BC.performance;
						result += Math.max(pathA[time].pq.poll().performance, pathB[time].pq.poll().performance);
					}
				}
			}
			// 3. 성능의 최대 합(result)을 출력한다.
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}

	static class User {
		int row, col;
		PriorityQueue<BC> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.performance, o1.performance));
		
		public User(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		boolean isWithinBC(BC bc) {
			int distance = Math.abs(this.row-bc.row)+ Math.abs(this.col-bc.col);
			return distance <= bc.range;
		}
	}
	
	static class BC {
		int row, col, range, performance;

		public BC(int row, int col, int range, int performance) {
			this.row = row;
			this.col = col;
			this.range = range;
			this.performance = performance;
		}
	}
}