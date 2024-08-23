import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA.1247 최적경로 
 *	0. 회사->고객1->...->고객N->집 까지의 최단 경로를 찾는다. 최악에 10! 이므로 완전탐색 한다.
 *  1. 고객의 수와 회사, 집, 고객들의 좌표를 입력받는다.
 *  	1-1. 회사와 집의 좌표는 첫 방문, 마지막 방문의 고정이므로 미리 selectPoints에 추가시킨다.
 *  	1-2. 고객 좌표들을 입력받아 points 배열에 저장한다.
 *  2. 회사와 집 좌표는 첫번째와 마지막으로 고정시키고 고객들의 좌표만 모든 순열을 찾는다.
 *  	2-1. [기저조건] 고객들의 좌표가 인덱스 1~(size+1) 까지 저장되므로 selectIdx가 (size+1)이 되면 종료.
 *  		2-1-1. 고객N->집 까지의 경로를 더해주고 result 값을 갱신한다.
 *  	2-2. 방문처리 후 고객[idx-1]->고객[idx] 까지 경로를 파라미터에 누적시키고 다음 경로를 찾아나간다.
 *  3. 최단 경로가 저장된 result 값을 출력한다.
 */
public class Solution {
	static int size, cnt, result;
	static Point[] points, selectPoints;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 고객의 수와 회사, 집, 고객들의 좌표를 입력받는다.
			size = Integer.parseInt(br.readLine());
			points = new Point[size+2];
			selectPoints = new Point[size+2];
			st = new StringTokenizer(br.readLine());
			
			// 1-1. 회사와 집의 좌표는 첫 방문, 마지막 방문의 고정이므로 미리 selectList에 추가시킨다.
			points[0] = selectPoints[0] 
					= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			points[size+1] = selectPoints[size+1] 
					= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 1-2. 고객 좌표들을 입력받아 points 배열에 저장한다.
			for(int idx=1; idx<=size; idx++) {
				points[idx] 
						= new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		
			// 2. 회사와 집 좌표는 첫번째와 마지막으로 고정시키고 고객들의 좌표만 모든 순열을 찾는다.
			visited = new boolean[size+2];
			result = Integer.MAX_VALUE;
			permutation(1, 0);
			
			// 3. 최단 경로가 저장된 result 값을 출력한다.
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
	
	static void permutation(int selectIdx, int sumDistance) {
		if(sumDistance >= result) return;
		
		// 2-1. [기저조건] 고객들의 좌표가 인덱스 1~(size+1) 까지 저장되므로 selectIdx가 (size+1)이 되면 종료.
		if(selectIdx == size + 1) {
			// 2-1-1. 고객N->집 까지의 경로를 더해주고 result 값을 갱신한다.
			result = Math.min(result, sumDistance + selectPoints[selectIdx-1].getDistance(selectPoints[selectIdx]));
			return;
		}
		
		for(int pointIdx=1; pointIdx<=size; pointIdx++) {
			if(visited[pointIdx]) continue;
			
			visited[pointIdx] = true;
			// 2-2. 방문처리 후 고객[idx-1]->고객[idx] 까지 경로를 파라미터에 누적시키고 다음 경로를 찾아나간다.
			selectPoints[selectIdx] = points[pointIdx];
			permutation(selectIdx + 1, sumDistance + points[pointIdx].getDistance(selectPoints[selectIdx-1]));
			visited[pointIdx] = false;
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		int getDistance(Point p) {
			return Math.abs(this.x - p.x)+ Math.abs(this.y - p.y); 
		}
	}
}
