import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	SWEA.2117 홈방범서비스
 *
 * 	1. 서비스영역 1~SIZE까지 살펴보기
 * 	2. 0~rowSize, 0~colSize 시작하는 마름모 bfs 탐색하기
 *
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
			
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			homeCharge = Integer.parseInt(st.nextToken());
			
			map = new int[size][size];
			homeList = new ArrayList<>();
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					if(map[row][col] == 1) homeList.add(new int[] {row, col});
				}
			}
			
			maxHomeCnt = 1;
			for(int serviceArea=2; serviceArea<=size+1; serviceArea++) {
				int manageCost = serviceArea*serviceArea + (serviceArea-1)*(serviceArea-1);
				for(int row=0; row<size; row++) {
					for(int col=0; col<size; col++) {
						int homeCnt = 0;
						for (int[] home : homeList) {
							int dist = getDistance(home[0], home[1], row, col);
							if(dist < serviceArea) homeCnt++;
						}
						
						int profit = homeCharge*homeCnt - manageCost;
						if(profit >= 0) {
							maxHomeCnt = Math.max(maxHomeCnt, homeCnt);
						}
						if(maxHomeCnt == homeList.size()) break;
					}
					if(maxHomeCnt == homeList.size()) break;
				}
				if(maxHomeCnt == homeList.size()) break;
			}
			
			sb.append(maxHomeCnt).append('\n');
		}
		System.out.print(sb);
	}
	
	static int getDistance(int row1, int col1, int row2, int col2) {
		return Math.abs(row1 - row2) + Math.abs(col1 - col2);
	}
}