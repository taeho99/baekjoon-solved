import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *	SWEA.2117 홈방범서비스
 *
 * 	1. 맵의 크기와 집의 이용료, 맵의 정보를 입력받는다.
 * 		1-1. 집의 좌표를 리스트에 저장한다.
 * 	2. K = 1일 때 가능한 집의 개수는 무조건 1이므로 초기값으로 설정
 * 	3. K = 2 ~ (size+1)인 경우를 모든 좌표를 중심점에 둬보고 확인해본다.
 * 		3-1. 현재 서비스 영역과 중심점의 좌표에서 모든 집 리스트를 확인한다.
 * 			3-1-1. 집이 서비스 영역 내에 있으면 집의 개수를 카운팅한다.
 * 		3-2. 보안 회사의 이익을 계산한다.
 * 		3-3. 손해보지 않을 정도(이익>=0)면 최대 집의 개수를 갱신한다.
 * 		3-4. 만약 최대 집의 개수가 전체 집의 개수와 동일하면 정답을 찾은 것이므로 더 이상 탐색하지 않는다.
 * 	4. 최대 가능한 집의 개수를 출력한다.
 */
public class Solution {
	static int size, homeCharge, maxHomeCnt;
	static int[][] map;
	static List<int[]> homeList;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 맵의 크기와 집의 이용료, 맵의 정보를 입력받는다.
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			homeCharge = Integer.parseInt(st.nextToken());
			
			map = new int[size][size];
			homeList = new ArrayList<>();
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					// 1-1. 집의 좌표를 리스트에 저장한다.
					if(map[row][col] == 1) homeList.add(new int[] {row, col});
				}
			}
			
			// 2. K = 1일 때 가능한 집의 개수는 무조건 1이므로 초기값으로 설정
			maxHomeCnt = 1; // serviceArea == 1일 때
			
			// 3. K = 2 ~ (size+1)인 경우를 모든 좌표를 중심점에 둬보고 확인해본다.
			for(int serviceArea=size+1; serviceArea>=2; serviceArea--) {
				int manageCost = serviceArea*serviceArea + (serviceArea-1)*(serviceArea-1);
				for(int row=0; row<size; row++) {
					for(int col=0; col<size; col++) {
						
						// 3-1. 현재 서비스 영역과 중심점의 좌표에서 모든 집 리스트를 확인한다.
						int homeCnt = 0;
						for (int[] home : homeList) {
							// 3-1-1. 집이 서비스 영역 내에 있으면 집의 개수를 카운팅한다.
							int dist = getDistance(home[0], home[1], row, col);
							if(dist < serviceArea) homeCnt++;
						}
						
						// 3-2. 보안 회사의 이익을 계산한다.
						int profit = homeCharge*homeCnt - manageCost;
						// 3-3. 손해보지 않을 정도(이익>=0)면 최대 집의 개수를 갱신한다.
						if(profit >= 0) {
							maxHomeCnt = Math.max(maxHomeCnt, homeCnt);
						}
						
						// 3-4. 만약 최대 집의 개수가 전체 집의 개수와 동일하면 정답을 찾은 것이므로 더 이상 탐색하지 않는다.
						if(maxHomeCnt == homeList.size()) break;
					}
					if(maxHomeCnt == homeList.size()) break;
				}
				if(maxHomeCnt == homeList.size()) break;
			}
			
			// 4. 최대 가능한 집의 개수를 출력한다.
			sb.append(maxHomeCnt).append('\n');
		}
		System.out.print(sb);
	}
	
	static int getDistance(int row1, int col1, int row2, int col2) {
		return Math.abs(row1 - row2) + Math.abs(col1 - col2);
	}
}