import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	static int size, homeCharge, maxHomeCnt, totalHomeCnt;
	static int[][] map;
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
			totalHomeCnt = 0;
			for(int row=0; row<size; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0; col<size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					if(map[row][col] == 1) totalHomeCnt++;
				}
			}
			
			maxHomeCnt = 1;
			for(int serviceArea=2; serviceArea<=size+1; serviceArea++) {
				int manageCost = serviceArea*serviceArea + (serviceArea-1)*(serviceArea-1);
				for(int row=0; row<size; row++) {
					for(int col=0; col<size; col++) {
						int homeCnt = bfs(row, col, serviceArea);
						int profit = homeCharge*homeCnt - manageCost;
						if(profit >= 0) {
							maxHomeCnt = Math.max(maxHomeCnt, homeCnt);
						}
						if(maxHomeCnt == totalHomeCnt) break;
					}
					if(maxHomeCnt == totalHomeCnt) break;
				}
				if(maxHomeCnt == totalHomeCnt) break;
			}
			
			sb.append(maxHomeCnt).append('\n');
		}
		System.out.print(sb);
	}
	private static int bfs(int startRow, int startCol, int serviceArea) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[size][size];
		
		queue.add(new int[] {startRow, startCol, 1});
		visited[startRow][startCol] = true;
		if(map[startRow][startCol] == 1) cnt++; 
		
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			
			int row = poll[0];
			int col = poll[1];
			int area = poll[2];
			
			for(int dir=0; dir<4; dir++) {
				int nRow = row + dRow[dir];
				int nCol = col + dCol[dir];
				int nArea = area + 1;
				
				if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || visited[nRow][nCol]) continue;
				
				if(nArea <= serviceArea) {
					if(map[nRow][nCol] == 1) cnt++;
					queue.add(new int[] {nRow, nCol, nArea});
					visited[nRow][nCol] = true;
				}
			}
		}
		return cnt;
	}

}